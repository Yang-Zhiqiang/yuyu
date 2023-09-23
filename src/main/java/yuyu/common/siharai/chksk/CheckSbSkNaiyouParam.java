package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック （死亡）請求内容チェックParamインターフェース
 */
public interface CheckSbSkNaiyouParam {

    public String getSyono();

    public void setSyono(String pSyono);

    public C_SeikyuusyaKbn getSeikyuusyakbn();

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn);

    public String getSeikyuusyanmkn();

    public void setSeikyuusyanmkn(String pSeikyuusyanmkn);

    public String getSeikyuusyanmkj();

    public void setSeikyuusyanmkj(String pSeikyuusyanmkj);

    public BizDate getSeikyuusyaseiymd();

    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd);

    public C_Seibetu getSeikyuusyasei();

    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei);

    public String getSkskknnmkn();

    public void setSkskknnmkn(String pSkskknnmkn);

    public String getSkskknnmkj();

    public void setSkskknnmkj(String pSkskknnmkj);

    public C_SkskknsyubetuKbn getSkskknsyubetu();

    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu);

    public C_SouhusakiKbn getSouhusakikbn();

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn);

    public String getTsinyno();

    public void setTsinyno(String pTsinyno);

    public String getTsinadr1kj();

    public void setTsinadr1kj(String pTsinadr1kj);

    public String getTsinadr2kj();

    public void setTsinadr2kj(String pTsinadr2kj);

    public String getTsinadr3kj();

    public void setTsinadr3kj(String pTsinadr3kj);

    public String getTsintelno();

    public void setTsintelno(String pTsintelno);

    public C_SiharaiTuukaKbn getSiharaituukakbn();

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn);

    public C_InputShrhousiteiKbn getInputshrhousiteikbn();

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn);

    public String getBankcd();

    public void setBankcd(String pBankcd);

    public String getSitencd();

    public void setSitencd(String pSitencd);

    public C_YokinKbn getYokinkbn();

    public void setYokinkbn(C_YokinKbn pYokinkbn);

    public String getKouzano();

    public void setKouzano(String pKouzano);

    public C_Kzdou getKzdoukbn();

    public void setKzdoukbn(C_Kzdou pKzdoukbn);

    public String getKzmeiginmkn();

    public void setKzmeiginmkn(String pKzmeiginmkn);

    public BizDate getSyoruiukeymd();

    public void setSyoruiukeymd(BizDate pSyoruiukeymd);

    public C_SUketoriHouhouKbn getSuketorihouhoukbn();

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn);

    public BizDate getSibouymd();

    public void setSibouymd(BizDate pSibouymd);

    public C_KanryotuutioutKbn getShrdtlsyooutkbn();

    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn);

    public C_HassouKbn getHassoukbn();

    public void setHassoukbn(C_HassouKbn pHassoukbn);

    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn();

    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn);

    public BizDate getHubikanryouymd();

    public void setHubikanryouymd(BizDate pHubikanryouymd);

    public C_GeninKbn getGeninkbn();

    public void setGeninkbn(C_GeninKbn pGeninkbn);

    public List<String> getByoumeitourokunolist();

    public void setByoumeitourokunolist(List<String> pByoumeitourokunolist);

    public C_YouhiKbn getSateikakmeigihnkkbn();

    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn);

    public C_UmuKbn getSateikakhusyousikbn();

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn);

    public C_UmuKbn getSateikakkaigaisbkbn();

    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn);

    public JT_SkKihon getSkkihon();

    public void setSkkihon(JT_SkKihon pSkkihon);

    public C_SaisateiKbn getSaisateikbn();

    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn);

    public String getSaikennmkj();

    public void setSaikennmkj(String pSaikennmkj);

    public String getSaikennyno();

    public void setSaikennyno(String pSaikennyno);

    public String getSaikenadr1kj();

    public void setSaikenadr1kj(String pSaikenadr1kj);

    public String getSaikenadr2kj();

    public void setSaikenadr2kj(String pSaikenadr2kj);

    public String getSaikenadr3kj();

    public void setSaikenadr3kj(String pSaikenadr3kj);

    public C_UmuKbn getSateikaksaigaikanouseikbn();

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn);

    public String getSkno();

    public void setSkno(String pSkno) ;

}
