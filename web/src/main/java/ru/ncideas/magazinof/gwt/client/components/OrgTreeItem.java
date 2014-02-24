package ru.ncideas.magazinof.gwt.client.components;

import com.google.gwt.user.client.ui.TreeItem;
import ru.ncideas.magazinof.gwt.client.dto.OrganizationDto;

public class OrgTreeItem extends TreeItem {

        private OrganizationDto org;

        public OrgTreeItem(OrganizationDto org) {
            super(org.getName());
            this.org = org;
        }

        public OrganizationDto getOrg() {
            return org;
        }

        public void setOrg(OrganizationDto org) {
            this.org = org;
        }
    }
