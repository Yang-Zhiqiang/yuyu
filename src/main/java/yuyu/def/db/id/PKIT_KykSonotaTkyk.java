package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.mapping.GenIT_KykSonotaTkyk;
import yuyu.def.db.meta.GenQIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約その他特約テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KykSonotaTkyk}</td><td colspan="3">契約その他特約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>livingneedshukaumu</td><td>リビングニーズ特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktkyhkumu</td><td>被保険者代理特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktkyhkymd</td><td>被保険者代理特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yennykntkhkumu</td><td>円入金特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gaikanykntkhkumu</td><td>外貨入金特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>yenshrtkhkumu</td><td>円支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>yenshrkykkykhenkoymd</td><td>円支払特約契約変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkgkkateitkumu</td><td>年金額確定特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nksgkhosyuwari</td><td>年金総額保証割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>skjbrnktsumu</td><td>即時払年金特則有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nenkingaku8waritkumu</td><td>年金額８割保証特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nenkingaku9waritkumu</td><td>年金額９割保証特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkyentkhukaumu</td><td>年金円支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kwsttkhukaumu</td><td>為替ターゲット特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kwstargetrate</td><td>為替ターゲットレート</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>targettkhkumu</td><td>ターゲット特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>targettkykkykhenkoymd</td><td>ターゲット特約契約変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>targettkkbn</td><td>ターゲット特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TargetTkKbn C_TargetTkKbn}</td></tr>
 *  <tr><td>targettkmokuhyouti</td><td>ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ysknkshtkumu</td><td>新遺族年金支払特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pmnjtkkbn</td><td>保険料免除特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmnjtkKbn C_PmnjtkKbn}</td></tr>
 *  <tr><td>pmnjtkkykymd</td><td>保険料免除特約契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pmnjtksknnkaisiymd</td><td>保険料免除特約責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pmnjtkgansknnkaisiymd</td><td>保険料免除特約がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pmhktsknnkaisiymd</td><td>保険料免除特約復活責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pmnjhktgansknnkaisiymd</td><td>保険料免除特約復活がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pmnjtkhtnpbuicd1</td><td>保険料免除特約不担保部位コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmnjtkhtnpkkn1</td><td>保険料免除特約不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>pmnjtkhtnpbuicd2</td><td>保険料免除特約不担保部位コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmnjtkhtnpkkn2</td><td>保険料免除特約不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>pmnjtkhtnpbuicd3</td><td>保険料免除特約不担保部位コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmnjtkhtnpkkn3</td><td>保険料免除特約不担保期間３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>pmnjtkhtnpbuicd4</td><td>保険料免除特約不担保部位コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmnjtkhtnpkkn4</td><td>保険料免除特約不担保期間４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>pmnjtokkoudosghtnpkbn</td><td>保険料免除特約特定高度障害不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokkoudosghtnpKbn C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>sknnkaisikitkkbn</td><td>責任開始期特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SknnkaisikitkKbn C_SknnkaisikitkKbn}</td></tr>
 *  <tr><td>nstkhkumu</td><td>年金支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkshrtkykhenkoymd</td><td>年金支払特約契約変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkshrtkyknksyukbn</td><td>年金支払特約年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nstknsyu C_Nstknsyu}</td></tr>
 *  <tr><td>nkshrtkyknksyukkn</td><td>年金支払特約年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jyudkaigomeharaitkhukaumu</td><td>重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jyudkaigomeharaitkhukaymd</td><td>重度介護前払特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>targettkykhkymd</td><td>ターゲット特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>targettkykkijyungk</td><td>ターゲット特約基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zeiseitkkktkykhukaumu</td><td>税制適格特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zeiseitkkktkykhukaymd</td><td>税制適格特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeiseitkkktkyksyoumetuymd</td><td>税制適格特約消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yennyknsyuruikbn</td><td>円入金特約種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YennykntksyuruiKbn C_YennykntksyuruiKbn}</td></tr>
 *  <tr><td>kykdrtkykhukaumu</td><td>契約者代理特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykdrtkykhukaymd</td><td>契約者代理特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykdrtkykkaiyakuymd</td><td>契約者代理特約解約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>teikishrtkykhukaumu</td><td>定期支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>teikishrkinshrtuukasyu</td><td>定期支払金支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>teikishrkinshrmd</td><td>定期支払金支払月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDateMD</td></tr>
 * </table>
 * @see     IT_KykSonotaTkyk
 * @see     GenIT_KykSonotaTkyk
 * @see     QIT_KykSonotaTkyk
 * @see     GenQIT_KykSonotaTkyk
 */
public class PKIT_KykSonotaTkyk extends AbstractExDBPrimaryKey<IT_KykSonotaTkyk, PKIT_KykSonotaTkyk> {

    private static final long serialVersionUID = 1L;

    public PKIT_KykSonotaTkyk() {
    }

    public PKIT_KykSonotaTkyk(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_KykSonotaTkyk> getEntityClass() {
        return IT_KykSonotaTkyk.class;
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

}