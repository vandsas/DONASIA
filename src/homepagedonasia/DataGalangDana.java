package homepagedonasia;

public class DataGalangDana {
    private String judul, tujuan, penggalang, waktu, cerita;

    public DataGalangDana(String judul, String tujuan, String penggalang, String waktu, String cerita) {
        this.judul = judul;
        this.tujuan = tujuan;
        this.penggalang = penggalang;
        this.waktu = waktu;
        this.cerita = cerita;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getPenggalang() {
        return penggalang;
    }

    public void setPenggalang(String penggalang) {
        this.penggalang = penggalang;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getCerita() {
        return cerita;
    }

    public void setCerita(String cerita) {
        this.cerita = cerita;
    }
    
    
    
}
