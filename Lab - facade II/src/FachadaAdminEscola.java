import admin.facade.SistemaFacade;
import school.facades.FachadaControleAcademico;

public class FachadaAdminEscola {
    public final FachadaControleAcademico escola;
    public final SistemaFacade admin;

    public FachadaAdminEscola() {
        this.escola = new FachadaControleAcademico();
        this.admin = new SistemaFacade();
    }

}
