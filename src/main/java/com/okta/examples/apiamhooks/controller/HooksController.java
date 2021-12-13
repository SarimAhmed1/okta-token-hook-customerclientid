package com.okta.examples.apiamhooks.controller;

import com.okta.examples.apiamhooks.model.hooks.IDTokenPatchResponse;
import com.okta.examples.apiamhooks.model.hooks.TokenHookRequest;
import com.okta.examples.apiamhooks.model.hooks.TokenHookResponse;
import com.okta.examples.apiamhooks.model.hooks.TokenPatchResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hooks")
public class HooksController {

    @PostMapping("/apiam")
    public TokenHookResponse apiam(@RequestBody TokenHookRequest request) {
        String login = request.getData().getContext().getUser().getProfile().getLogin();

        TokenHookResponse response = new TokenHookResponse();

        IDTokenPatchResponse idTokenPatchResponse = new IDTokenPatchResponse();
        idTokenPatchResponse.getValue().add(
            new TokenPatchResponse.Value(
                "add", "/claims/beers", "hi"
            )
        );
        response.getCommands().add(idTokenPatchResponse);

        
        return response;
    }
    @RequestMapping("/")
    public String hi() {
        return "sup";
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "https://dev-59044126.okta.com/oauth2/default");
    }

}
