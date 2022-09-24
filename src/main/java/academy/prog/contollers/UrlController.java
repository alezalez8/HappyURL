package academy.prog.contollers;

import academy.prog.dto.UrlDTO;
import academy.prog.dto.UrlResultDTO;
import academy.prog.service.UrlService;
import academy.prog.dto.UrlStatDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
//@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8080")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(path = "shorten")
    public UrlResultDTO shorten(@RequestBody UrlDTO urlDTO) {
        long id = urlService.saveUrl(urlDTO);

        var result = new UrlResultDTO();
        result.setUrl(urlDTO.getUrl());
        result.setShortUrl(Long.toString(id));

        return result;
    }


    @GetMapping("my/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") Long id) {
        var url = urlService.getUrl(id);

        var headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        headers.setCacheControl("no-cache, no-store, must-revalidate");


        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/admin")
    public List<UrlStatDTO> stat() {
        return urlService.getStatistics();
    }


    @GetMapping("myy/{id}")
    public String redirectTwo(@PathVariable("id") Long id) {
        String  url = urlService.getUrl(id);
        return url;
    }
}
