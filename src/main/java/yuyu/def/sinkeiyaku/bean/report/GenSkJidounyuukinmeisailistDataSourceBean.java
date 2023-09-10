package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）自動入金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkJidounyuukinmeisailistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkJidounyuukinmeisailistDataSourceBean() {
    }


    private String irAtesaki;


    public String getIrAtesaki() {
        return irAtesaki;
    }


    public void setIrAtesaki(String pIrAtesaki) {
        irAtesaki = pIrAtesaki;
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }


    private Integer irPageno;


    public Integer getIrPageno() {
        return irPageno;
    }


    public void setIrPageno(Integer pIrPageno) {
        irPageno = pIrPageno;
    }


    private String irListnm;


    public String getIrListnm() {
        return irListnm;
    }


    public void setIrListnm(String pIrListnm) {
        irListnm = pIrListnm;
    }


    private String irNyukintuuka;


    public String getIrNyukintuuka() {
        return irNyukintuuka;
    }


    public void setIrNyukintuuka(String pIrNyukintuuka) {
        irNyukintuuka = pIrNyukintuuka;
    }


    private String irDenymd;


    public String getIrDenymd() {
        return irDenymd;
    }


    public void setIrDenymd(String pIrDenymd) {
        irDenymd = pIrDenymd;
    }


    private Integer irTjkensuu;


    public Integer getIrTjkensuu() {
        return irTjkensuu;
    }


    public void setIrTjkensuu(Integer pIrTjkensuu) {
        irTjkensuu = pIrTjkensuu;
    }


    private BizCurrency irTjgk;


    public BizCurrency getIrTjgk() {
        return irTjgk;
    }


    public void setIrTjgk(BizCurrency pIrTjgk) {
        irTjgk = pIrTjgk;
    }


    private BizCurrency irTjgkyen;


    public BizCurrency getIrTjgkyen() {
        return irTjgkyen;
    }


    public void setIrTjgkyen(BizCurrency pIrTjgkyen) {
        irTjgkyen = pIrTjgkyen;
    }


    private Integer irZenjitukurikosikensuu;


    public Integer getIrZenjitukurikosikensuu() {
        return irZenjitukurikosikensuu;
    }


    public void setIrZenjitukurikosikensuu(Integer pIrZenjitukurikosikensuu) {
        irZenjitukurikosikensuu = pIrZenjitukurikosikensuu;
    }


    private BizCurrency irZenjitukurikosigk;


    public BizCurrency getIrZenjitukurikosigk() {
        return irZenjitukurikosigk;
    }


    public void setIrZenjitukurikosigk(BizCurrency pIrZenjitukurikosigk) {
        irZenjitukurikosigk = pIrZenjitukurikosigk;
    }


    private Integer irHrkmtsrykensuu;


    public Integer getIrHrkmtsrykensuu() {
        return irHrkmtsrykensuu;
    }


    public void setIrHrkmtsrykensuu(Integer pIrHrkmtsrykensuu) {
        irHrkmtsrykensuu = pIrHrkmtsrykensuu;
    }


    private BizCurrency irHrkmtsrykingk;


    public BizCurrency getIrHrkmtsrykingk() {
        return irHrkmtsrykingk;
    }


    public void setIrHrkmtsrykingk(BizCurrency pIrHrkmtsrykingk) {
        irHrkmtsrykingk = pIrHrkmtsrykingk;
    }


    private String irJigyouhicd;


    public String getIrJigyouhicd() {
        return irJigyouhicd;
    }


    public void setIrJigyouhicd(String pIrJigyouhicd) {
        irJigyouhicd = pIrJigyouhicd;
    }


    private Integer irSgittikensuu;


    public Integer getIrSgittikensuu() {
        return irSgittikensuu;
    }


    public void setIrSgittikensuu(Integer pIrSgittikensuu) {
        irSgittikensuu = pIrSgittikensuu;
    }


    private BizCurrency irSgittigk;


    public BizCurrency getIrSgittigk() {
        return irSgittigk;
    }


    public void setIrSgittigk(BizCurrency pIrSgittigk) {
        irSgittigk = pIrSgittigk;
    }


    private BizCurrency irSgittigkyen;


    public BizCurrency getIrSgittigkyen() {
        return irSgittigkyen;
    }


    public void setIrSgittigkyen(BizCurrency pIrSgittigkyen) {
        irSgittigkyen = pIrSgittigkyen;
    }


    private Integer irSghuittikensuu;


    public Integer getIrSghuittikensuu() {
        return irSghuittikensuu;
    }


    public void setIrSghuittikensuu(Integer pIrSghuittikensuu) {
        irSghuittikensuu = pIrSghuittikensuu;
    }


    private BizCurrency irSghuittigk;


    public BizCurrency getIrSghuittigk() {
        return irSghuittigk;
    }


    public void setIrSghuittigk(BizCurrency pIrSghuittigk) {
        irSghuittigk = pIrSghuittigk;
    }


    private Integer irMostrkskensuu;


    public Integer getIrMostrkskensuu() {
        return irMostrkskensuu;
    }


    public void setIrMostrkskensuu(Integer pIrMostrkskensuu) {
        irMostrkskensuu = pIrMostrkskensuu;
    }


    private BizCurrency irMostrksgk;


    public BizCurrency getIrMostrksgk() {
        return irMostrksgk;
    }


    public void setIrMostrksgk(BizCurrency pIrMostrksgk) {
        irMostrksgk = pIrMostrksgk;
    }


    private Integer irYuukoukknkeikakensuu;


    public Integer getIrYuukoukknkeikakensuu() {
        return irYuukoukknkeikakensuu;
    }


    public void setIrYuukoukknkeikakensuu(Integer pIrYuukoukknkeikakensuu) {
        irYuukoukknkeikakensuu = pIrYuukoukknkeikakensuu;
    }


    private BizCurrency irYuukoukknkeikagk;


    public BizCurrency getIrYuukoukknkeikagk() {
        return irYuukoukknkeikagk;
    }


    public void setIrYuukoukknkeikagk(BizCurrency pIrYuukoukknkeikagk) {
        irYuukoukknkeikagk = pIrYuukoukknkeikagk;
    }


    private Integer irYokukurikosikensuu;


    public Integer getIrYokukurikosikensuu() {
        return irYokukurikosikensuu;
    }


    public void setIrYokukurikosikensuu(Integer pIrYokukurikosikensuu) {
        irYokukurikosikensuu = pIrYokukurikosikensuu;
    }


    private BizCurrency irYokukurikosigk;


    public BizCurrency getIrYokukurikosigk() {
        return irYokukurikosigk;
    }


    public void setIrYokukurikosigk(BizCurrency pIrYokukurikosigk) {
        irYokukurikosigk = pIrYokukurikosigk;
    }


    private BizCurrency irYokukurikosigkyen;


    public BizCurrency getIrYokukurikosigkyen() {
        return irYokukurikosigkyen;
    }


    public void setIrYokukurikosigkyen(BizCurrency pIrYokukurikosigkyen) {
        irYokukurikosigkyen = pIrYokukurikosigkyen;
    }


    private Integer irBankmdhntgtgkngkcount;


    public Integer getIrBankmdhntgtgkngkcount() {
        return irBankmdhntgtgkngkcount;
    }


    public void setIrBankmdhntgtgkngkcount(Integer pIrBankmdhntgtgkngkcount) {
        irBankmdhntgtgkngkcount = pIrBankmdhntgtgkngkcount;
    }


    private BizCurrency irBankmdhntgtgkngk;


    public BizCurrency getIrBankmdhntgtgkngk() {
        return irBankmdhntgtgkngk;
    }


    public void setIrBankmdhntgtgkngk(BizCurrency pIrBankmdhntgtgkngk) {
        irBankmdhntgtgkngk = pIrBankmdhntgtgkngk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
