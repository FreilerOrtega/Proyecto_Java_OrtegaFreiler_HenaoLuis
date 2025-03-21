package Modelo;

public class Cita {
    private int id_mascota;
    private String fecha;
    private String motivo_consulta;
    private int id_veterinaro;
    private String diagnostico;
    private boolean asistencia;
    private String  estado;

    public Cita() {
    }

    public Cita(int id_mascota, String fecha, String motivo_consulta, int id_veterinaro, String diagnostico, boolean asistencia, String estado) {
        this.id_mascota = id_mascota;
        this.fecha = fecha;
        this.motivo_consulta = motivo_consulta;
        this.id_veterinaro = id_veterinaro;
        this.diagnostico = diagnostico;
        this.asistencia = asistencia;
        this.estado = estado;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public int getId_veterinaro() {
        return id_veterinaro;
    }

    public void setId_veterinaro(int id_veterinaro) {
        this.id_veterinaro = id_veterinaro;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
