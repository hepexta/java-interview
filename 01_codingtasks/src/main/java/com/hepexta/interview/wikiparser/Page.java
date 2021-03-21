package com.hepexta.interview.wikiparser;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Page {
    private String pageUrl;
    private String name;
    private String author;
    private String content;
    private List<String> links;
}
