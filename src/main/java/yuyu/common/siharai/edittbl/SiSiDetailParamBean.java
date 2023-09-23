package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HushrSyousaiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細パラメータBean
 */
public class SiSiDetailParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uketukeno;

    private C_SyutkKbn syutkkbn;

    private String syouhncd;

    private C_KyhgndkataKbn kyhgndkatakbn;

    private Integer syouhnsdno;

    private Integer kyksyouhnrenno;

    private String kyuuhucd;

    private Integer renno;

    private C_KyuuhuKbn kyuuhukbn;

    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    private C_Kanjyoukmkcd kanjyoukmkcd;

    private C_UmuKbn checktaisyouumukbn;

    private C_NitigakuHokenKngkKbn nitigakuhokenkngkkbn;

    private BizCurrency nitigakuhokenkngk;

    private Integer nissuubairitu;

    private C_KyhkinTaniKbn kyhkintanikbn;

    private BizCurrency kyhkg;

    private BizCurrency yenkyhgk;

    private Integer hutanponissuu;

    private BizDate shrriyuugaitouymd;

    private C_UmuKbn hknskgnkkntgtumukbn;

    private BizNumber hokenkinshrwariai;

    private String bikoumsg1;

    private String bikoumsg2;

    private String bikoumsg3;

    private String bikoumsg4;

    private String syouhnnmgm;

    private String syouhnnmtyhy;

    private String kyuuhunamegamen;

    private String kyuuhunamereport;

    private C_ShrKekkaKbn shrkekkakbn;

    private C_HushrSyousaiKbn hushrsyousaikbn;

    private BizCurrency kyhkngkgoukei;

    private BizCurrency sitihsyutkyumaeyenhknkngk;

    private String utiwakeparam;

    public SiSiDetailParamBean() {
        uketukeno = 1;
        syutkkbn = C_SyutkKbn.NONE;
        syouhncd = "";
        kyhgndkatakbn = C_KyhgndkataKbn.BLNK;
        syouhnsdno = 0;
        kyksyouhnrenno = 0;
        kyuuhucd = "";
        renno = 0;
        kyuuhukbn = C_KyuuhuKbn.BLNK;
        hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        kanjyoukmkcd = C_Kanjyoukmkcd.BLNK;
        checktaisyouumukbn = C_UmuKbn.NONE;
        nitigakuhokenkngkkbn = C_NitigakuHokenKngkKbn.BLNK;
        nitigakuhokenkngk = BizCurrency.valueOf(0);
        nissuubairitu = 0;
        kyhkintanikbn = C_KyhkinTaniKbn.BLNK;
        kyhkg = BizCurrency.valueOf(0);
        yenkyhgk = BizCurrency.valueOf(0);
        hutanponissuu = 0;
        shrriyuugaitouymd = null;
        hknskgnkkntgtumukbn = C_UmuKbn.NONE;
        hokenkinshrwariai = BizNumber.valueOf(0);
        bikoumsg1 = "";
        bikoumsg2 = "";
        bikoumsg3 = "";
        bikoumsg4 = "";
        syouhnnmgm = "";
        syouhnnmtyhy = "";
        kyuuhunamegamen = "";
        kyuuhunamereport = "";
        shrkekkakbn = C_ShrKekkaKbn.BLNK;
        hushrsyousaikbn = C_HushrSyousaiKbn.BLNK;
        kyhkngkgoukei = BizCurrency.valueOf(0);
        sitihsyutkyumaeyenhknkngk = BizCurrency.valueOf(0);
        utiwakeparam = "";
    }

    public Integer getUketukeno() {
        return uketukeno;
    }

    public void setUketukeno(Integer pUketukeno) {
        uketukeno = pUketukeno;
    }

    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return kyhgndkatakbn;
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        kyhgndkatakbn = pKyhgndkatakbn;
    }

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    public C_KyuuhuKbn getKyuuhukbn() {
        return kyuuhukbn;
    }

    public void setKyuuhukbn(C_KyuuhuKbn pKyuuhukbn) {
        kyuuhukbn = pKyuuhukbn;
    }

    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruikbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruikbn) {
        hokenkinsyuruikbn = pHokenkinsyuruikbn;
    }

    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    public C_UmuKbn getChecktaisyouumukbn() {
        return checktaisyouumukbn;
    }

    public void setChecktaisyouumukbn(C_UmuKbn pChecktaisyouumukbn) {
        checktaisyouumukbn = pChecktaisyouumukbn;
    }

    public C_NitigakuHokenKngkKbn getNitigakuhokenkngkkbn() {
        return nitigakuhokenkngkkbn;
    }

    public void setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn pNitigakuhokenkngkkbn) {
        nitigakuhokenkngkkbn = pNitigakuhokenkngkkbn;
    }

    public BizCurrency getNitigakuhokenkngk() {
        return nitigakuhokenkngk;
    }

    public void setNitigakuhokenkngk(BizCurrency pNitigakuhokenkngk) {
        nitigakuhokenkngk = pNitigakuhokenkngk;
    }

    public Integer getNissuubairitu() {
        return nissuubairitu;
    }

    public void setNissuubairitu(Integer pNissuubairitu) {
        nissuubairitu = pNissuubairitu;
    }

    public C_KyhkinTaniKbn getKyhkintanikbn() {
        return kyhkintanikbn;
    }

    public void setKyhkintanikbn(C_KyhkinTaniKbn pKyhkintanikbn) {
        kyhkintanikbn = pKyhkintanikbn;
    }

    public BizCurrency getKyhkg() {
        return kyhkg;
    }

    public void setKyhkg(BizCurrency pKyhkg) {
        kyhkg = pKyhkg;
    }

    public BizCurrency getYenkyhgk() {
        return yenkyhgk;
    }

    public void setYenkyhgk(BizCurrency pYenkyhgk) {
        yenkyhgk = pYenkyhgk;
    }

    public Integer getHutanponissuu() {
        return hutanponissuu;
    }

    public void setHutanponissuu(Integer pHutanponissuu) {
        hutanponissuu = pHutanponissuu;
    }

    public BizDate getShrriyuugaitouymd() {
        return shrriyuugaitouymd;
    }

    public void setShrriyuugaitouymd(BizDate pShrriyuugaitouymd) {
        shrriyuugaitouymd = pShrriyuugaitouymd;
    }

    public C_UmuKbn getHknskgnkkntgtumukbn() {
        return hknskgnkkntgtumukbn;
    }

    public void setHknskgnkkntgtumukbn(C_UmuKbn pHknskgnkkntgtumukbn) {
        hknskgnkkntgtumukbn = pHknskgnkkntgtumukbn;
    }

    public BizNumber getHokenkinshrwariai() {
        return hokenkinshrwariai;
    }

    public void setHokenkinshrwariai(BizNumber pHokenkinshrwariai) {
        hokenkinshrwariai = pHokenkinshrwariai;
    }

    public String getBikoumsg1() {
        return bikoumsg1;
    }

    public void setBikoumsg1(String pBikoumsg1) {
        bikoumsg1 = pBikoumsg1;
    }

    public String getBikoumsg2() {
        return bikoumsg2;
    }

    public void setBikoumsg2(String pBikoumsg2) {
        bikoumsg2 = pBikoumsg2;
    }

    public String getBikoumsg3() {
        return bikoumsg3;
    }

    public void setBikoumsg3(String pBikoumsg3) {
        bikoumsg3 = pBikoumsg3;
    }

    public String getBikoumsg4() {
        return bikoumsg4;
    }

    public void setBikoumsg4(String pBikoumsg4) {
        bikoumsg4 = pBikoumsg4;
    }

    public String getSyouhnnmgm() {
        return syouhnnmgm;
    }

    public void setSyouhnnmgm(String pSyouhnnmgm) {
        syouhnnmgm = pSyouhnnmgm;
    }

    public String getSyouhnnmtyhy() {
        return syouhnnmtyhy;
    }

    public void setSyouhnnmtyhy(String pSyouhnnmtyhy) {
        syouhnnmtyhy = pSyouhnnmtyhy;
    }

    public String getKyuuhunamegamen() {
        return kyuuhunamegamen;
    }

    public void setKyuuhunamegamen(String pKyuuhunamegamen) {
        kyuuhunamegamen = pKyuuhunamegamen;
    }

    public String getKyuuhunamereport() {
        return kyuuhunamereport;
    }

    public void setKyuuhunamereport(String pKyuuhunamereport) {
        kyuuhunamereport = pKyuuhunamereport;
    }

    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    public C_HushrSyousaiKbn getHushrsyousaikbn() {
        return hushrsyousaikbn;
    }

    public void setHushrsyousaikbn(C_HushrSyousaiKbn pHushrsyousaikbn) {
        hushrsyousaikbn = pHushrsyousaikbn;
    }

    public BizCurrency getKyhkngkgoukei() {
        return kyhkngkgoukei;
    }

    public void setKyhkngkgoukei(BizCurrency pKyhkngkgoukei) {
        kyhkngkgoukei = pKyhkngkgoukei;
    }

    public BizCurrency getSitihsyutkyumaeyenhknkngk() {
        return sitihsyutkyumaeyenhknkngk;
    }

    public void setSitihsyutkyumaeyenhknkngk(BizCurrency pSitiHsyuTkyumaeYenHknKngk) {
        sitihsyutkyumaeyenhknkngk = pSitiHsyuTkyumaeYenHknKngk;
    }

    public String getUtiwakeparam() {
        return utiwakeparam;
    }

    public void setUtiwakeparam(String pUtiwakeparam) {
        utiwakeparam = pUtiwakeparam;
    }

}
