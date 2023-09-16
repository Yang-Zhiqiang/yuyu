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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.mapping.GenIT_AzukarikinKessankanri;
import yuyu.def.db.meta.GenQIT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 預り金決算管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AzukarikinKessankanri}</td><td colspan="3">預り金決算管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yuukousyoumetukbn</td><td>有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukousyoumetuKbn C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kbnkeirisegcd</td><td>区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>azukarikinhsiymd</td><td>預り金発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>azukarigankin</td><td>預り元金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>azukarijikikbn</td><td>預り時期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AzukarijikiKbn C_AzukarijikiKbn}</td></tr>
 *  <tr><td>azukariganrikin</td><td>預り元利金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tounendgankin</td><td>当年度元金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tounendrsk</td><td>当年度利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kwsratekjymd</td><td>為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kawaserate</td><td>為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gaikaazukariganrikin</td><td>外貨預り元利金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikatounendgankin</td><td>外貨当年度元金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikatounendrsk</td><td>外貨当年度利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikashrkwsratekjnymd</td><td>外貨支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gaikashrkwsrate</td><td>外貨支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gaikaknsnmaeazukariganrikin</td><td>外貨換算前預り元利金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikaknsnmaetounendgankin</td><td>外貨換算前当年度元金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikaknsnmaetounendrsk</td><td>外貨換算前当年度利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>azukarikinshrgk</td><td>預り金支払額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>azukarikinshrrskgk</td><td>預り金支払利息額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tounendsyoumetuukemishrgk</td><td>当年度消滅受付未支払額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sinbikinkeirskgk</td><td>新備金計上利息額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>bknjkukbn</td><td>備金時効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknJkuKbn C_BknJkuKbn}</td></tr>
 *  <tr><td>bikinkeiymd</td><td>備金計上日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bkncdkbn</td><td>備金コード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BkncdKbn C_BkncdKbn}</td></tr>
 *  <tr><td>tounendrsksyukeisitu</td><td>当年度利息（主計室用）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennendrsksyukeisitu</td><td>前年度利息（主計室用）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kwsratekjymd1q</td><td>（１Ｑ）為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kawaserate1q</td><td>（１Ｑ）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>azukarikinrsk1q</td><td>（１Ｑ）預り金利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kwsratekjymd2q</td><td>（２Ｑ）為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kawaserate2q</td><td>（２Ｑ）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>azukarikinrsk2q</td><td>（２Ｑ）預り金利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kwsratekjymd3q</td><td>（３Ｑ）為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kawaserate3q</td><td>（３Ｑ）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>azukarikinrsk3q</td><td>（３Ｑ）預り金利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kwsratekjymd4q</td><td>（４Ｑ）為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kawaserate4q</td><td>（４Ｑ）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>azukarikinrsk4q</td><td>（４Ｑ）預り金利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AzukarikinKessankanri
 * @see     GenIT_AzukarikinKessankanri
 * @see     QIT_AzukarikinKessankanri
 * @see     GenQIT_AzukarikinKessankanri
 */
public class PKIT_AzukarikinKessankanri extends AbstractExDBPrimaryKey<IT_AzukarikinKessankanri, PKIT_AzukarikinKessankanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_AzukarikinKessankanri() {
    }

    public PKIT_AzukarikinKessankanri(
        String pSyono,
        BizDate pKessankijyunymd,
        String pHenkousikibetukey,
        C_Tuukasyu pTuukasyu
    ) {
        syono = pSyono;
        kessankijyunymd = pKessankijyunymd;
        henkousikibetukey = pHenkousikibetukey;
        tuukasyu = pTuukasyu;
    }

    @Transient
    @Override
    public Class<IT_AzukarikinKessankanri> getEntityClass() {
        return IT_AzukarikinKessankanri.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate kessankijyunymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

}