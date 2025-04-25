package com.aem.ford.core.models.footer;

import java.util.List;

import com.aem.ford.core.models.footer.impl.FooterLinksGroupModel;

public interface FooterModel {
    List<FooterLinksGroupModel> getGroups();
}