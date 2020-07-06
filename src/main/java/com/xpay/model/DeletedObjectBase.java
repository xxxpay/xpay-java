package com.xpay.model;

/**
 * Created by Afon on 17/03/27.
 */
public abstract class DeletedObjectBase extends XPayObject implements DeletedXPayObject {
    String id;
    Boolean deleted;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}