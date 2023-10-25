package com.imtechsolutions.imponto.persistence.responses;

public class InsercaoObraResponse {
    private int idObra;
    private boolean success;
    private String messageText;

    public InsercaoObraResponse(int idObra, boolean success, String messageText) {
        this.idObra = idObra;
        this.success = success;
        this.messageText = messageText;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}

