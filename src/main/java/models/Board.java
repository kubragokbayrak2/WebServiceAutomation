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
public class Board {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("desc")
    private String desc;
    
    @JsonProperty("closed")
    private boolean closed;
    
    @JsonProperty("idOrganization")
    private String idOrganization;
    
    @JsonProperty("pinned")
    private boolean pinned;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("shortUrl")
    private String shortUrl;

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

    public boolean isClosed() {
        return closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public boolean isPinned() {
        return pinned;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }
} 