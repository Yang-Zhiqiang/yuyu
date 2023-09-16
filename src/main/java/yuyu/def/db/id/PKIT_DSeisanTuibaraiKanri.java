package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import yuyu.def.db.mapping.GenIT_DSeisanTuibaraiKanri;
import yuyu.def.db.meta.GenQIT_DSeisanTuibaraiKanri;
import yuyu.def.db.meta.QIT_DSeisanTuibaraiKanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * Ｄ精算追払管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DSeisanTuibaraiKanri}</td><td colspan="3">Ｄ精算追払管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">○</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrhousiteikbn</td><td>支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrhousiteiKbn C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>inputshrhousiteikbn</td><td>入力用支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InputShrhousiteiKbn C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>tuibaraiyouhikbn</td><td>追払要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>tuutisakuseiyouhikbn</td><td>通知作成要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>dseisansouhusakihnsyukbn</td><td>Ｄ精算送付先編集区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DseisansouhusakihnsyuKbn C_DseisansouhusakihnsyuKbn}</td></tr>
 *  <tr><td>dseisantetudukimeikbn</td><td>Ｄ精算手続名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DseisantetudukimeiKbn C_DseisantetudukimeiKbn}</td></tr>
 *  <tr><td>shrymd</td><td>支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtienrskkisanymd</td><td>支払遅延利息起算日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tienrsknissuu</td><td>遅延利息日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>gsbunritaisyou</td><td>源泉分離課税対象</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>yenshrtkumu</td><td>円支払特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kzsyuruikbn</td><td>口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouzasyuruiKbn C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzdoukbn</td><td>口座名義人同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kzdou C_Kzdou}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gaikashrkwsratekjnymd</td><td>外貨支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gaikashrkwsrate</td><td>外貨支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zeimukwsratekjnymd</td><td>税務用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeimukwsrate</td><td>税務用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>nztodouhukencd</td><td>納税先都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yensynykngk</td><td>円換算収入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenhtykeihi</td><td>円換算必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkztgk</td><td>円換算課税対象額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrkykhtykeihi</td><td>円換算支払時契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykhnkkaisuu</td><td>契約者変更回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrtysykurikosiyouhi</td><td>支払調書繰越要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>soukinsakinmkj</td><td>送金先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiyno</td><td>送金先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiadr1kj</td><td>送金先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiadr2kj</td><td>送金先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiadr3kj</td><td>送金先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaiyakujiyuu</td><td>解約事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kaiyakujiyuu C_Kaiyakujiyuu}</td></tr>
 *  <tr><td>shrtuukashrgkgoukei</td><td>支払通貨支払額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukagstszeigk</td><td>支払通貨源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukashrtienrsk</td><td>支払通貨支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukasonotashrkngk</td><td>支払通貨その他支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansanhaitoukin</td><td>円換算配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yensonotahaitoukin</td><td>円換算その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrgkgoukei</td><td>円換算支払額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yengstszeigk</td><td>円換算源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yengstszeigknationaltax</td><td>円換算源泉徴収税額（国税）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yengstszeigklocaltax</td><td>円換算源泉徴収税額（地方税）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrtienrsk</td><td>円換算支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotashrkngkyen</td><td>その他支払金額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotashrkngksiteituuka</td><td>その他支払金額（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zeitratkikbn</td><td>税取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZeitratkiKbn C_ZeitratkiKbn}</td></tr>
 * </table>
 * @see     IT_DSeisanTuibaraiKanri
 * @see     GenIT_DSeisanTuibaraiKanri
 * @see     QIT_DSeisanTuibaraiKanri
 * @see     GenQIT_DSeisanTuibaraiKanri
 */
public class PKIT_DSeisanTuibaraiKanri extends AbstractExDBPrimaryKey<IT_DSeisanTuibaraiKanri, PKIT_DSeisanTuibaraiKanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_DSeisanTuibaraiKanri() {
    }

    public PKIT_DSeisanTuibaraiKanri(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        haitounendo = pHaitounendo;
    }

    @Transient
    @Override
    public Class<IT_DSeisanTuibaraiKanri> getEntityClass() {
        return IT_DSeisanTuibaraiKanri.class;
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
    private BizDateY haitounendo;

    @org.hibernate.annotations.Type(type="BizDateYType")
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

}