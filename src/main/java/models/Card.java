package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("desc")
    private String desc;
    
    @JsonProperty("idList")
    private String idList;
    
    @JsonProperty("idBoard")
    private String idBoard;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("closed")
    private boolean closed;
    
    @JsonProperty("shortUrl")
    private String shortUrl;
    
    @JsonProperty("subscribed")
    private boolean subscribed;

    // Manuel getter metodları
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getIdList() {
        return idList;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public String getUrl() {
        return url;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public boolean isSubscribed() {
        return subscribed;
    }
} 