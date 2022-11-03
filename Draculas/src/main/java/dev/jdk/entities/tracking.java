package dev.jdk.entities;

public class tracking {
    private String trackingno;
    private String status;
    public tracking(){

    }
    public tracking(String trackingno,String status){
        this.trackingno=trackingno;
        this.status=status;
    }

    public String getTrackingno() {
        return trackingno;
    }

    public void setTrackingno(String trackingno) {
        this.trackingno = trackingno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "tracking{" +
                "trackingno='" + trackingno + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
