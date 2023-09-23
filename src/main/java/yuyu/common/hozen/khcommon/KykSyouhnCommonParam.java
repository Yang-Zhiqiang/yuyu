package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 *  契約保全 契約保全共通 契約商品共通パラメータ
 */
public interface KykSyouhnCommonParam{

    public String getKbnkey();

    public void setKbnkey(String pKbnkey);

    public String getSyono();

    public void setSyono(String pSyono);

    public C_SyutkKbn getSyutkkbn();

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn);

    public String getSyouhncd();

    public void setSyouhncd(String pSyouhncd);

    public Integer getSyouhnsdno();

    public void setSyouhnsdno(Integer pSyouhnsdno);

    public Integer getKyksyouhnrenno();

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno);

    public String getHenkousikibetukey();

    public void setHenkousikibetukey(String pHenkousikibetukey);

    public C_YuukousyoumetuKbn getYuukousyoumetukbn();

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn);

    public C_Kykjyoutai getKykjyoutai();

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai);

    public C_Syoumetujiyuu getSyoumetujiyuu();

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu);

    public BizDate getSyoumetuymd();

    public void setSyoumetuymd(BizDate pSyoumetuymd);

    public BizDate getKouryokuhasseiymd();

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd);

    public BizDate getKykymd();

    public void setKykymd(BizDate pKykymd);

    public C_UmuKbn getKykymdsiteiumukbn();

    public void setKykymdsiteiumukbn(C_UmuKbn pKykymdsiteiumukbn);

    public BizDate getSknnkaisiymd();

    public void setSknnkaisiymd(BizDate pSknnkaisiymd);

    public BizDate getGansknnkaisiymd();

    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd);

    public BizDate getHksknnkaisiymd();

    public void setHksknnkaisiymd(BizDate pHksknnkaisiymd);

    public BizDate getHkgansknnkaisiymd();

    public void setHkgansknnkaisiymd(BizDate pHkgansknnkaisiymd);

    public C_HknkknsmnKbn getHknkknsmnkbn();

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn);

    public Integer getHknkkn();

    public void setHknkkn(Integer pHknkkn);

    public C_HrkkknsmnKbn getHrkkknsmnkbn();

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn);

    public Integer getHrkkkn();

    public void setHrkkkn(Integer pHrkkkn);

    public Integer getKyknen();

    public void setKyknen(Integer pKyknen);

    public Integer getHhknnen();

    public void setHhknnen(Integer pHhknnen);

    public BizDate getHhknseiymd();

    public void setHhknseiymd(BizDate pHhknseiymd);

    public C_Hhknsei getHhknsei();

    public void setHhknsei(C_Hhknsei pHhknsei);

    public BizDate getHaraimanymd();

    public void setHaraimanymd(BizDate pHaraimanymd);

    public BizDate getHknkknmanryouymd();

    public void setHknkknmanryouymd(BizDate pHknkknmanryouymd);

    public C_KataKbn getKatakbn();

    public void setKatakbn(C_KataKbn pKatakbn);

    public C_KyhgndkataKbn getKyhgndkatakbn();

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn);

    public C_SyukyhkinkataKbn getSyukyhkinkatakbn();

    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn);

    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn();

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn);

    public C_6daiLdKbn getRokudaildkbn();

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn);

    public C_PmnjtkKbn getPmnjtkkbn();

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn);

    public BizCurrency getKihons();

    public void setKihons(BizCurrency pKihons);

    public BizCurrency getHokenryou();

    public void setHokenryou(BizCurrency pHokenryou);

    public C_Tuukasyu getKyktuukasyu();

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    public String getRyouritusdno();

    public void setRyouritusdno(String pRyouritusdno);

    public BizNumber getYoteiriritu();

    public void setYoteiriritu(BizNumber pYoteiriritu);

    public BizNumber getYoteirrthendohosyurrt();

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt);

    public Integer getYtirrthndmnskaisuu();

    public void setYtirrthndmnskaisuu(Integer pYtirrthndmnskaisuu);

    public BizNumber getKyksjkkktyouseiriritu();

    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu);

    public C_Nenkinsyu getNksyukbn();

    public void setNksyukbn(C_Nenkinsyu pNksyukbn);

    public Integer getNenkinkkn();

    public void setNenkinkkn(Integer pNenkinkkn);

    public Integer getNkgnshosyouritu();

    public void setNkgnshosyouritu(Integer pNkgnshosyouritu);

    public BizCurrency getNkgnshosyougk();

    public void setNkgnshosyougk(BizCurrency pNkgnshosyougk);

    public String getGyoumuKousinKinou();

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou);

    public String getGyoumuKousinsyaId();

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId);

    public String getGyoumuKousinTime();

    public void setGyoumuKousinTime(String pGyoumuKousinTime);

    public BizCurrency getGengakugoyenitijibrpstgk();

    public void setGengakugoyenitijibrpstgk(BizCurrency pGengakugoyenitijibrpstgk);

    public BizDate getYendthnkymd();

    public void setYendthnkymd(BizDate pYendthnkymd);

    public BizNumber getSetteibairitu();

    public void setSetteibairitu(BizNumber pSetteibairitu);

    public BizNumber getKykjisisuurendourate();

    public void setKykjisisuurendourate(BizNumber pKykjisisuurendourate);

    public BizNumber getTmttknzoukaritujygn();

    public void setTmttknzoukaritujygn(BizNumber pTmttknzoukaritujygn);

    public BizNumber getTumitateriritu();

    public void setTumitateriritu(BizNumber pTumitateriritu);

    public C_TmttknhaibunjyoutaiKbn getTmttknhaibunjyoutai();

    public void setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai);

    public C_Sisuukbn getSisuukbn();

    public void setSisuukbn(C_Sisuukbn pSisuukbn);

    public C_UmuKbn getGsbunrikzkakuninumu();

    public void setGsbunrikzkakuninumu(C_UmuKbn pGsbunrikzkakuninumu);

    public C_UmuKbn getGsbunritaisyou();

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou);

    public BizCurrency getPharaikomisougaku();

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku);

    public BizDate getTmttknitenymd();

    public void setTmttknitenymd(BizDate pTmttknitenymd);

    public BizNumber getLoadinghnkgtumitateriritu();

    public void setLoadinghnkgtumitateriritu(BizNumber pLoadinghnkgtumitateriritu);

    public BizNumber getRendouritu();

    public void setRendouritu(BizNumber pRendouritu);

    public BizNumber getTeikishrritu();

    public void setTeikishrritu(BizNumber pTeikishrritu);

    public Integer getDai1hknkkn();

    public void setDai1hknkkn(Integer pDai1hknkkn);

}
