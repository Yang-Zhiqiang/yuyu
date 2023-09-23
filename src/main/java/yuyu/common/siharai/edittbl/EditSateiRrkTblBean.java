package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import yuyu.def.db.entity.JT_SateiSyouninRireki;


/**
 * 保険金給付金支払 保険金給付金支払共通 査定承認履歴TBL編集Beanクラス
 */
public class EditSateiRrkTblBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skno;

    private String syono;

    private String sateisyouninskbtkey;

    private Integer seikyuurirekino;

    private JT_SateiSyouninRireki sateiSyouninRireki;

    public EditSateiRrkTblBean() {
        super();

        skno = "";

        syono = "";

        sateisyouninskbtkey = "";

        seikyuurirekino = 0;

        sateiSyouninRireki = new JT_SateiSyouninRireki();
    }

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getSateisyouninskbtkey() {
        return sateisyouninskbtkey;
    }

    public void setSateisyouninskbtkey(String pSateisyouninskbtkey) {
        sateisyouninskbtkey = pSateisyouninskbtkey;
    }

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    public JT_SateiSyouninRireki getSateiSyouninRireki() {
        return sateiSyouninRireki;
    }

    public void setSateiSyouninRireki(JT_SateiSyouninRireki pSateiSyouninRireki) {
        sateiSyouninRireki = pSateiSyouninRireki;
    }

}
