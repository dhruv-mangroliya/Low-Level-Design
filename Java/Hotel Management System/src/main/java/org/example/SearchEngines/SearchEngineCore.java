package org.example.SearchEngines;

import org.example.Model.Hotel;
import org.example.SearchRequest.Request;

import java.util.List;

public interface SearchEngineCore {
    public List<Hotel> search(Request request);
}
