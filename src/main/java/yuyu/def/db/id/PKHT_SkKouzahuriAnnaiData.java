package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.def.db.mapping.GenHT_SkKouzahuriAnnaiData;
import yuyu.def.db.meta.GenQHT_SkKouzahuriAnnaiData;
import yuyu.def.db.meta.QHT_SkKouzahuriAnnaiData;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約口座振替案内データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkKouzahuriAnnaiData}</td><td colspan="3">新契約口座振替案内データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hurikaeymd</td><td>振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinkeizkkbn</td><td>新規継続区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinkeizkKbn C_SinkeizkKbn}</td></tr>
 *  <tr><td>syuyakukyohikbn</td><td>集約拒否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuyakukyohiKbn C_SyuyakukyohiKbn}</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daimosno</td><td>代表申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyuruicd</td><td>保険種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknkaisyacd</td><td>保険会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkidrtenkbn</td><td>取扱代理店区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TratkidrtenKbn C_TratkidrtenKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkKouzahuriAnnaiData
 * @see     GenHT_SkKouzahuriAnnaiData
 * @see     QHT_SkKouzahuriAnnaiData
 * @see     GenQHT_SkKouzahuriAnnaiData
 */
public class PKHT_SkKouzahuriAnnaiData extends AbstractExDBPrimaryKey<HT_SkKouzahuriAnnaiData, PKHT_SkKouzahuriAnnaiData> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkKouzahuriAnnaiData() {
    }

    public PKHT_SkKouzahuriAnnaiData(
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pMosno,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym
    ) {
        ansyuusyskbn = pAnsyuusyskbn;
        syoriYmd = pSyoriYmd;
        mosno = pMosno;
        nyknaiyoukbn = pNyknaiyoukbn;
        jyuutouym = pJyuutouym;
    }

    @Transient
    @Override
    public Class<HT_SkKouzahuriAnnaiData> getEntityClass() {
        return HT_SkKouzahuriAnnaiData.class;
    }

    private C_AnsyuusysKbn ansyuusyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_AnsyuusysKbn")
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return ansyuusyskbn;
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        ansyuusyskbn = pAnsyuusyskbn;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_NyknaiyouKbn nyknaiyoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_NyknaiyouKbn")
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }
    private BizDateYM jyuutouym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

}