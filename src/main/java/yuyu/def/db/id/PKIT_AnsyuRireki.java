package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.mapping.GenIT_AnsyuRireki;
import yuyu.def.db.meta.GenQIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AnsyuRireki}</td><td colspan="3">案内収納履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnnaino annaino}</td><td>案内番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>ryosyukwsratekjymd</td><td>領収為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ryosyukwsrate</td><td>領収為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>iktwaribikikgk</td><td>一括割引料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>annaijkkbn</td><td>案内状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AnnaijkKbn C_AnnaijkKbn}</td></tr>
 *  <tr><td>annaisakuseiymd</td><td>案内作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>minyusyoriymd</td><td>未入処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dattaiuktkymd</td><td>脱退受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hurikaeymd</td><td>振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hurihunokbn</td><td>振替不能理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HurihunoKbn C_HurihunoKbn}</td></tr>
 *  <tr><td>uriageymdkon</td><td>売上日（今回）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>krkkeijyoflg</td><td>仮受計上フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>krkkeijyoymd</td><td>仮受計上処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>krkno</td><td>仮受番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinkeizkkbn</td><td>新規継続区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinkeizkKbn C_SinkeizkKbn}</td></tr>
 *  <tr><td>syuyakukyohikbn</td><td>集約拒否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuyakukyohiKbn C_SyuyakukyohiKbn}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardkaisyacd</td><td>カード会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yukoukachkymd</td><td>有効性確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>authorikanryoymd</td><td>オーソリ完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uriageymdzen</td><td>売上日（前回）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkkigen</td><td>払込期限</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>minyutuutizumiflg</td><td>未入通知作成済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Skszumiflg C_Skszumiflg}</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credituriagengjiyuu</td><td>クレジットカード売上請求ＮＧ事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditUriageNgJiyuuKbn C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AnsyuRireki
 * @see     GenIT_AnsyuRireki
 * @see     QIT_AnsyuRireki
 * @see     GenQIT_AnsyuRireki
 */
public class PKIT_AnsyuRireki extends AbstractExDBPrimaryKey<IT_AnsyuRireki, PKIT_AnsyuRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_AnsyuRireki() {
    }

    public PKIT_AnsyuRireki(
        String pKbnkey,
        String pSyono,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym,
        Integer pAnnaino
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        nyknaiyoukbn = pNyknaiyoukbn;
        jyuutouym = pJyuutouym;
        annaino = pAnnaino;
    }

    @Transient
    @Override
    public Class<IT_AnsyuRireki> getEntityClass() {
        return IT_AnsyuRireki.class;
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
    private Integer annaino;

    public Integer getAnnaino() {
        return annaino;
    }

    public void setAnnaino(Integer pAnnaino) {
        annaino = pAnnaino;
    }

}