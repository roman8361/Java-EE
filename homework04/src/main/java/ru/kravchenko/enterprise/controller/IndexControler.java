package ru.kravchenko.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Roman Kravchenko
 */

@ViewScoped
@ManagedBean
@URLMapping(
        id = "index",
        pattern = "/index",
        viewId = "/WEB-INF/faces/index.xhtml")
public class IndexControler {

}
