package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.mapping.GenMW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.meta.GenQMW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.meta.QMW_DsNeugokiHanteiKekkaWk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ値動き判定結果ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MW_DsNeugokiHanteiKekkaWk}</td><td colspan="3">ＤＳ値動き判定結果ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskokno</td><td>ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailaddressrenban</td><td>ＤＳメールアドレス連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuujiaatukaidrtencd</td><td>募集時Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuujibatukaidrtencd</td><td>募集時Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kaiyakuhryen</td><td>解約返戻金（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>itijibrp</td><td>一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>neugokihanteikjnkngk</td><td>値動き判定基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>neugokiwari</td><td>値動き割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>neugokitoutatulinefile</td><td>値動き到達ライン（ファイル）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>neugokitoutatulinemail</td><td>値動き到達ライン（メール）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>neugokihanteiumukbn</td><td>値動き判定有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mailsousinyhkbn</td><td>メール送信要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>mailaddresstourokuumukbn</td><td>メールアドレス登録有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dssousinno</td><td>ＤＳ送信番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MW_DsNeugokiHanteiKekkaWk
 * @see     GenMW_DsNeugokiHanteiKekkaWk
 * @see     QMW_DsNeugokiHanteiKekkaWk
 * @see     GenQMW_DsNeugokiHanteiKekkaWk
 */
public class PKMW_DsNeugokiHanteiKekkaWk extends AbstractExDBPrimaryKey<MW_DsNeugokiHanteiKekkaWk, PKMW_DsNeugokiHanteiKekkaWk> {

    private static final long serialVersionUID = 1L;

    public PKMW_DsNeugokiHanteiKekkaWk() {
    }

    public PKMW_DsNeugokiHanteiKekkaWk(BizDate pDsdatasakuseiymd, String pSyono) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<MW_DsNeugokiHanteiKekkaWk> getEntityClass() {
        return MW_DsNeugokiHanteiKekkaWk.class;
    }

    private BizDate dsdatasakuseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDsdatasakuseiymd() {
        return dsdatasakuseiymd;
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}