package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 *  新契約成立情報共通インターフェース
 */
public interface SinkeiyakuSeirituInfoParam {

    public String getMosno();

    public void setMosno(String pMosno);

    public String getSyono();

    public void setSyono(String pSyono);

    public BizDate getMosnrkymd();

    public void setMosnrkymd(BizDate pMosnrkymd);

    public C_SeirituKbn getSeiritukbn();

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn);

    public BizDate getSrsyoriymd();

    public void setSrsyoriymd(BizDate pSrsyoriymd);

    public BizDate getMosymd();

    public void setMosymd(BizDate pMosymd);

    public BizDate getMossakuseiymd();

    public void setMossakuseiymd(BizDate pMossakuseiymd);

    public BizDateYM getMosym();

    public void setMosym(BizDateYM pMosym);

    public BizDate getKykymd();

    public void setKykymd(BizDate pKykymd);

    public BizDate getSkykymd();

    public void setSkykymd(BizDate pSkykymd);

    public BizDate getSknnkaisiymd();

    public void setSknnkaisiymd(BizDate pSknnkaisiymd);

    public BizDateYM getSeisekiym();

    public void setSeisekiym(BizDateYM pSeisekiym);

    public BizDateYM getSkeikeijyouym();

    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym);

    public C_KykKbn getKykkbn();

    public void setKykkbn(C_KykKbn pKykkbn);

    public C_Tkhukaumu getStdrsktkyhkkbn();

    public void setStdrsktkyhkkbn(C_Tkhukaumu pStdrsktkyhkkbn);

    public C_Sdpd getSdpdkbn();

    public void setSdpdkbn(C_Sdpd pSdpdkbn);

    public C_SntkhouKbn getSntkhoukbn();

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn);

    public C_HaitouKbn getHaitoukbn();

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn);

    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn();

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn);

    public C_Tuukasyu getKyktuukasyu();

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    public C_Tuukasyu getHrktuukasyu();

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu);

    public BizCurrency getHyouteip();

    public void setHyouteip(BizCurrency pHyouteip);

    public String getHhknnmkn();

    public void setHhknnmkn(String pHhknnmkn);

    public String getHhknnmkj();

    public void setHhknnmkj(String pHhknnmkj);

    public BizDate getHhknseiymd();

    public void setHhknseiymd(BizDate pHhknseiymd);

    public Integer getHhknnen();

    public void setHhknnen(Integer pHhknnen);

    public C_Hhknsei getHhknsei();

    public void setHhknsei(C_Hhknsei pHhknsei);

    public String getHhknsykgycd();

    public void setHhknsykgycd(String pHhknsykgycd);

    public String getKyknmkn();

    public void setKyknmkn(String pKyknmkn);

    public String getKyknmkj();

    public void setKyknmkj(String pKyknmkj);

    public BizDate getKykseiymd();

    public void setKykseiymd(BizDate pKykseiymd);

    public Integer getKyknen();

    public void setKyknen(Integer pKyknen);

    public C_Kyksei getKyksei();

    public void setKyksei(C_Kyksei pKyksei);

    public String getTsinyno();

    public void setTsinyno(String pTsinyno);

    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn();

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn);

    public BizDate getKktymd();

    public void setKktymd(BizDate pKktymd);

    public C_Kykkaksyrui getKykkaksyrui();

    public void setKykkaksyrui(C_Kykkaksyrui pKykkaksyrui);

    public C_SpgndtknKbn getSpgndtknkbn();

    public void setSpgndtknkbn(C_SpgndtknKbn pSpgndtknkbn);

    public C_NenkkntknKbn getNenkkntknkbn();

    public void setNenkkntknkbn(C_NenkkntknKbn pNenkkntknkbn);

    public C_TsngndtknKbn getTsngndtknkbn();

    public void setTsngndtknkbn(C_TsngndtknKbn pTsngndtknkbn);

    public C_SentakuinfotknKbn getSentakuinfotknkbn();

    public void setSentakuinfotknkbn(C_SentakuinfotknKbn pSentakuinfotknkbn);

    public C_KakoymdkyytknKbn getKakoymdkyytknkbn();

    public void setKakoymdkyytknkbn(C_KakoymdkyytknKbn pKakoymdkyytknkbn);

    public C_SaiteiptknKbn getSaiteiptknkbn();

    public void setSaiteiptknkbn(C_SaiteiptknKbn pSaiteiptknkbn);

    public C_SignalkaihiKbn getSignalkaihikbn();

    public void setSignalkaihikbn(C_SignalkaihiKbn pSignalkaihikbn);

    public C_SonotaTokuninKbn getSonotatknkbn();

    public void setSonotatknkbn(C_SonotaTokuninKbn pSonotatknkbn);

    public String getDrtenkanritodoufukencd();

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd);

    public C_UmuKbn getYenshrtkhkumu();

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu);

    public C_UmuKbn getInitsbjiyensitihsytkhukaumu();

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu);

    public BizCurrency getInitsbjiyenkasaiteihsygk();

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk);

    public C_UmuKbn getJyudkaigomeharaitkhukaumu();

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu);

    public C_UmuKbn getTargettkhkumu();

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu);

    public BizDate getTargettkykkykhenkoymd();

    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd);

    public Integer getTargettkmokuhyouti();

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti);

    public BizCurrency getTargettkykkijyungk();

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk);

    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn();

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn);

    public C_Sisuukbn getSisuukbn();

    public void setSisuukbn(C_Sisuukbn pSisuukbn);

    public C_Hrkkaisuu getHrkkaisuu();

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu);

    public C_Hrkkeiro getHrkkeiro();

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro);

    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu();

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu);

    public Integer getZnnkai();

    public void setZnnkai(Integer pZnnkai);

    public BizCurrency getHeijyunp();

    public void setHeijyunp(BizCurrency pHeijyunp);

    public BizNumber getNyknkwsrate();

    public void setNyknkwsrate(BizNumber pNyuukinKawaseRate);

    public C_Tkhukaumu getKykdrtkykhukakbn();

    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn);

    public C_UmuKbn getTeikishrtkykhukaumu();

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu);

    public C_UmuKbn getZennoumousideumu();

    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu);
}
