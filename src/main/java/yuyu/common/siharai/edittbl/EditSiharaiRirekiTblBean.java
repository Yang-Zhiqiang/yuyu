package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JT_SiRireki;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払履歴TBL編集Beanクラス
 */
public class EditSiharaiRirekiTblBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skno;

    private String syono;

    private String shrsikibetukey;

    private Integer seikyuurirekino;

    private C_ShrKekkaKbn shrkekkakbn;

    private BizDate shrsyoriymd;

    private C_ZeitratkiKbn zeitratkikbn;

    private C_UmuKbn torikesiflg;

    private BizDate torikesiymd;

    private JT_SiRireki sirireki;

    public EditSiharaiRirekiTblBean() {
        super();

        skno = "";

        syono = "";

        shrsikibetukey = "";

        seikyuurirekino = 0;

        shrkekkakbn = C_ShrKekkaKbn.BLNK;

        shrsyoriymd = null;

        zeitratkikbn = C_ZeitratkiKbn.BLNK;

        torikesiflg = C_UmuKbn.NONE;

        torikesiymd = null;

        sirireki = new JT_SiRireki();
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

    public String getShrsikibetukey() {
        return shrsikibetukey;
    }

    public void setShrsikibetukey(String pShrsikibetukey) {
        shrsikibetukey = pShrsikibetukey;
    }

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    public C_UmuKbn getTorikesiflg() {
        return torikesiflg;
    }

    public void setTorikesiflg(C_UmuKbn pTorikesiflg) {
        torikesiflg = pTorikesiflg;
    }

    public BizDate getTorikesiymd() {
        return torikesiymd;
    }

    public void setTorikesiymd(BizDate pTorikesiymd) {
        torikesiymd = pTorikesiymd;
    }

    public JT_SiRireki getSirireki() {
        return sirireki;
    }

    public void setSirireki(JT_SiRireki pSirireki) {
        sirireki = pSirireki;
    }

}
