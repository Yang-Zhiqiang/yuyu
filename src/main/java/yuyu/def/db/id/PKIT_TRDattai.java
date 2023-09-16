package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.mapping.GenIT_TRDattai;
import yuyu.def.db.meta.GenQIT_TRDattai;
import yuyu.def.db.meta.QIT_TRDattai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 脱退ＴＲテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRDattai}</td><td colspan="3">脱退ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDattaitrrenno dattaitrrenno}</td><td>脱退TR連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dattaikeiro</td><td>脱退経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Dattaikeiro C_Dattaikeiro}</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurihunokbn</td><td>振替不能理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HurihunoKbn C_HurihunoKbn}</td></tr>
 *  <tr><td>hurikaeymd</td><td>振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>creditdatakbn</td><td>クレジットデータ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditdataKbn C_CreditdataKbn}</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditbrerrorcd</td><td>クレジット払エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Creditbrerrorcd C_Creditbrerrorcd}</td></tr>
 *  <tr><td>dattaiym</td><td>脱退年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardbrandkbn</td><td>カードブランド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CardBrandKbn C_CardBrandKbn}</td></tr>
 *  <tr><td>creditkaiinnosimo4keta</td><td>クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRDattai
 * @see     GenIT_TRDattai
 * @see     QIT_TRDattai
 * @see     GenQIT_TRDattai
 */
public class PKIT_TRDattai extends AbstractExDBPrimaryKey<IT_TRDattai, PKIT_TRDattai> {

    private static final long serialVersionUID = 1L;

    public PKIT_TRDattai() {
    }

    public PKIT_TRDattai(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd,
        String pDattaitrrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        syoriYmd = pSyoriYmd;
        dattaitrrenno = pDattaitrrenno;
    }

    @Transient
    @Override
    public Class<IT_TRDattai> getEntityClass() {
        return IT_TRDattai.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String dattaitrrenno;

    public String getDattaitrrenno() {
        return dattaitrrenno;
    }

    public void setDattaitrrenno(String pDattaitrrenno) {
        dattaitrrenno = pDattaitrrenno;
    }

}