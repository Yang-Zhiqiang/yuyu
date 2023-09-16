package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.mapping.GenBM_ChkNenreiHani2;
import yuyu.def.db.meta.GenQBM_ChkNenreiHani2;
import yuyu.def.db.meta.QBM_ChkNenreiHani2;

/**
 * 年齢範囲チェックマスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenreiHani2}</td><td colspan="3">年齢範囲チェックマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknseifrom hhknseifrom}</td><td>被保険者性別自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknseito hhknseito}</td><td>被保険者性別至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyukatakbn syukatakbn}</td><td>主契約型区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuhknkkn syuhknkkn}</td><td>主契約保険期間</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuhknkknto syuhknkknto}</td><td>主契約保険期間至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuhknkknsmnkbn syuhknkknsmnkbn}</td><td>主契約保険期間歳満期区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuhrkkkn syuhrkkkn}</td><td>主契約払込期間</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuhrkkknto syuhrkkknto}</td><td>主契約払込期間至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuhrkkknsmnkbn syuhrkkknsmnkbn}</td><td>主契約払込期間歳満期区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyufromnen syufromnen}</td><td>主契約年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyutonen syutonen}</td><td>主契約年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuyoteiriritufrom syuyoteiriritufrom}</td><td>主契約予定利率自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuyoteirirituto syuyoteirirituto}</td><td>主契約予定利率至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyudai1hknkkn syudai1hknkkn}</td><td>主契約第１保険期間</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTokusyuchkno tokusyuchkno}</td><td>特殊チェック番号</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTksyouhncd tksyouhncd}</td><td>特約商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhknkkn tkhknkkn}</td><td>特約保険期間</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhknkknto tkhknkknto}</td><td>特約保険期間至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhknkknsmnkbn tkhknkknsmnkbn}</td><td>特約保険期間歳満期区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhrkkkn tkhrkkkn}</td><td>特約払込期間</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhrkkknto tkhrkkknto}</td><td>特約払込期間至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhrkkknsmnkbn tkhrkkknsmnkbn}</td><td>特約払込期間歳満期区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkfromnen tkfromnen}</td><td>特約年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTktonen tktonen}</td><td>特約年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_ChkNenreiHani2
 * @see     GenBM_ChkNenreiHani2
 * @see     QBM_ChkNenreiHani2
 * @see     GenQBM_ChkNenreiHani2
 */
public class PKBM_ChkNenreiHani2 extends AbstractExDBPrimaryKey<BM_ChkNenreiHani2, PKBM_ChkNenreiHani2> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkNenreiHani2() {
    }

    public PKBM_ChkNenreiHani2(
        C_Channelcd pChannelcd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pHhknseifrom,
        Integer pHhknseito,
        C_KataKbn pSyukatakbn,
        Integer pSyuhknkkn,
        Integer pSyuhknkknto,
        C_HknkknsmnKbn pSyuhknkknsmnkbn,
        Integer pSyuhrkkkn,
        Integer pSyuhrkkknto,
        C_HrkkknsmnKbn pSyuhrkkknsmnkbn,
        BizNumber pSyufromnen,
        BizNumber pSyutonen,
        BizNumber pSyuyoteiriritufrom,
        BizNumber pSyuyoteirirituto,
        Integer pSyudai1hknkkn,
        BizNumber pTokusyuchkno,
        String pTksyouhncd,
        BizNumber pTkhknkkn,
        Integer pTkhknkknto,
        C_HknkknsmnKbn pTkhknkknsmnkbn,
        BizNumber pTkhrkkkn,
        Integer pTkhrkkknto,
        C_HrkkknsmnKbn pTkhrkkknsmnkbn,
        BizNumber pTkfromnen,
        BizNumber pTktonen
    ) {
        channelcd = pChannelcd;
        syusyouhncd = pSyusyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        hhknseifrom = pHhknseifrom;
        hhknseito = pHhknseito;
        syukatakbn = pSyukatakbn;
        syuhknkkn = pSyuhknkkn;
        syuhknkknto = pSyuhknkknto;
        syuhknkknsmnkbn = pSyuhknkknsmnkbn;
        syuhrkkkn = pSyuhrkkkn;
        syuhrkkknto = pSyuhrkkknto;
        syuhrkkknsmnkbn = pSyuhrkkknsmnkbn;
        syufromnen = pSyufromnen;
        syutonen = pSyutonen;
        syuyoteiriritufrom = pSyuyoteiriritufrom;
        syuyoteirirituto = pSyuyoteirirituto;
        syudai1hknkkn = pSyudai1hknkkn;
        tokusyuchkno = pTokusyuchkno;
        tksyouhncd = pTksyouhncd;
        tkhknkkn = pTkhknkkn;
        tkhknkknto = pTkhknkknto;
        tkhknkknsmnkbn = pTkhknkknsmnkbn;
        tkhrkkkn = pTkhrkkkn;
        tkhrkkknto = pTkhrkkknto;
        tkhrkkknsmnkbn = pTkhrkkknsmnkbn;
        tkfromnen = pTkfromnen;
        tktonen = pTktonen;
    }

    @Transient
    @Override
    public Class<BM_ChkNenreiHani2> getEntityClass() {
        return BM_ChkNenreiHani2.class;
    }

    private C_Channelcd channelcd;

    @org.hibernate.annotations.Type(type="UserType_C_Channelcd")
    public C_Channelcd getChannelcd() {
        return channelcd;
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }
    private String syusyouhncd;

    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }
    private Integer syusyouhnsdnofrom;

    public Integer getSyusyouhnsdnofrom() {
        return syusyouhnsdnofrom;
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
    }
    private Integer syusyouhnsdnoto;

    public Integer getSyusyouhnsdnoto() {
        return syusyouhnsdnoto;
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        syusyouhnsdnoto = pSyusyouhnsdnoto;
    }
    private Integer hhknseifrom;

    public Integer getHhknseifrom() {
        return hhknseifrom;
    }

    public void setHhknseifrom(Integer pHhknseifrom) {
        hhknseifrom = pHhknseifrom;
    }
    private Integer hhknseito;

    public Integer getHhknseito() {
        return hhknseito;
    }

    public void setHhknseito(Integer pHhknseito) {
        hhknseito = pHhknseito;
    }
    private C_KataKbn syukatakbn;

    @org.hibernate.annotations.Type(type="UserType_C_KataKbn")
    public C_KataKbn getSyukatakbn() {
        return syukatakbn;
    }

    public void setSyukatakbn(C_KataKbn pSyukatakbn) {
        syukatakbn = pSyukatakbn;
    }
    private Integer syuhknkkn;

    public Integer getSyuhknkkn() {
        return syuhknkkn;
    }

    public void setSyuhknkkn(Integer pSyuhknkkn) {
        syuhknkkn = pSyuhknkkn;
    }
    private Integer syuhknkknto;

    public Integer getSyuhknkknto() {
        return syuhknkknto;
    }

    public void setSyuhknkknto(Integer pSyuhknkknto) {
        syuhknkknto = pSyuhknkknto;
    }
    private C_HknkknsmnKbn syuhknkknsmnkbn;

    @org.hibernate.annotations.Type(type="UserType_C_HknkknsmnKbn")
    public C_HknkknsmnKbn getSyuhknkknsmnkbn() {
        return syuhknkknsmnkbn;
    }

    public void setSyuhknkknsmnkbn(C_HknkknsmnKbn pSyuhknkknsmnkbn) {
        syuhknkknsmnkbn = pSyuhknkknsmnkbn;
    }
    private Integer syuhrkkkn;

    public Integer getSyuhrkkkn() {
        return syuhrkkkn;
    }

    public void setSyuhrkkkn(Integer pSyuhrkkkn) {
        syuhrkkkn = pSyuhrkkkn;
    }
    private Integer syuhrkkknto;

    public Integer getSyuhrkkknto() {
        return syuhrkkknto;
    }

    public void setSyuhrkkknto(Integer pSyuhrkkknto) {
        syuhrkkknto = pSyuhrkkknto;
    }
    private C_HrkkknsmnKbn syuhrkkknsmnkbn;

    @org.hibernate.annotations.Type(type="UserType_C_HrkkknsmnKbn")
    public C_HrkkknsmnKbn getSyuhrkkknsmnkbn() {
        return syuhrkkknsmnkbn;
    }

    public void setSyuhrkkknsmnkbn(C_HrkkknsmnKbn pSyuhrkkknsmnkbn) {
        syuhrkkknsmnkbn = pSyuhrkkknsmnkbn;
    }
    private BizNumber syufromnen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getSyufromnen() {
        return syufromnen;
    }

    public void setSyufromnen(BizNumber pSyufromnen) {
        syufromnen = pSyufromnen;
    }
    private BizNumber syutonen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getSyutonen() {
        return syutonen;
    }

    public void setSyutonen(BizNumber pSyutonen) {
        syutonen = pSyutonen;
    }
    private BizNumber syuyoteiriritufrom;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getSyuyoteiriritufrom() {
        return syuyoteiriritufrom;
    }

    public void setSyuyoteiriritufrom(BizNumber pSyuyoteiriritufrom) {
        syuyoteiriritufrom = pSyuyoteiriritufrom;
    }
    private BizNumber syuyoteirirituto;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getSyuyoteirirituto() {
        return syuyoteirirituto;
    }

    public void setSyuyoteirirituto(BizNumber pSyuyoteirirituto) {
        syuyoteirirituto = pSyuyoteirirituto;
    }
    private Integer syudai1hknkkn;

    public Integer getSyudai1hknkkn() {
        return syudai1hknkkn;
    }

    public void setSyudai1hknkkn(Integer pSyudai1hknkkn) {
        syudai1hknkkn = pSyudai1hknkkn;
    }
    private BizNumber tokusyuchkno;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getTokusyuchkno() {
        return tokusyuchkno;
    }

    public void setTokusyuchkno(BizNumber pTokusyuchkno) {
        tokusyuchkno = pTokusyuchkno;
    }
    private String tksyouhncd;

    public String getTksyouhncd() {
        return tksyouhncd;
    }

    public void setTksyouhncd(String pTksyouhncd) {
        tksyouhncd = pTksyouhncd;
    }
    private BizNumber tkhknkkn;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getTkhknkkn() {
        return tkhknkkn;
    }

    public void setTkhknkkn(BizNumber pTkhknkkn) {
        tkhknkkn = pTkhknkkn;
    }
    private Integer tkhknkknto;

    public Integer getTkhknkknto() {
        return tkhknkknto;
    }

    public void setTkhknkknto(Integer pTkhknkknto) {
        tkhknkknto = pTkhknkknto;
    }
    private C_HknkknsmnKbn tkhknkknsmnkbn;

    @org.hibernate.annotations.Type(type="UserType_C_HknkknsmnKbn")
    public C_HknkknsmnKbn getTkhknkknsmnkbn() {
        return tkhknkknsmnkbn;
    }

    public void setTkhknkknsmnkbn(C_HknkknsmnKbn pTkhknkknsmnkbn) {
        tkhknkknsmnkbn = pTkhknkknsmnkbn;
    }
    private BizNumber tkhrkkkn;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getTkhrkkkn() {
        return tkhrkkkn;
    }

    public void setTkhrkkkn(BizNumber pTkhrkkkn) {
        tkhrkkkn = pTkhrkkkn;
    }
    private Integer tkhrkkknto;

    public Integer getTkhrkkknto() {
        return tkhrkkknto;
    }

    public void setTkhrkkknto(Integer pTkhrkkknto) {
        tkhrkkknto = pTkhrkkknto;
    }
    private C_HrkkknsmnKbn tkhrkkknsmnkbn;

    @org.hibernate.annotations.Type(type="UserType_C_HrkkknsmnKbn")
    public C_HrkkknsmnKbn getTkhrkkknsmnkbn() {
        return tkhrkkknsmnkbn;
    }

    public void setTkhrkkknsmnkbn(C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        tkhrkkknsmnkbn = pTkhrkkknsmnkbn;
    }
    private BizNumber tkfromnen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getTkfromnen() {
        return tkfromnen;
    }

    public void setTkfromnen(BizNumber pTkfromnen) {
        tkfromnen = pTkfromnen;
    }
    private BizNumber tktonen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getTktonen() {
        return tktonen;
    }

    public void setTktonen(BizNumber pTktonen) {
        tktonen = pTktonen;
    }

}