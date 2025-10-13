package org.example.SearchRequest;

import lombok.Getter;
import org.example.Model.Hotel;

import java.util.List;

public abstract class Request {
    public abstract List<Hotel> search();
}
