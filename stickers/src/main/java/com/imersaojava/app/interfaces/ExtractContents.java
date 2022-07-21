package com.imersaojava.app.interfaces;

import com.imersaojava.app.entities.Conteudo;
import com.imersaojava.app.entities.Movie;

import java.util.List;

public interface ExtractContents {

    List<Conteudo> extractContent(String json);

}
