package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import yuyu.def.db.mapping.GenBT_TjtIdouNyKhItjhzn;
import yuyu.def.db.meta.GenQBT_TjtIdouNyKhItjhzn;
import yuyu.def.db.meta.QBT_TjtIdouNyKhItjhzn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 当日異動内容契約保全一時保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TjtIdouNyKhItjhzn}</td><td colspan="3">当日異動内容契約保全一時保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>recordsakujyohyouji</td><td>レコード削除表示</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>youkyuuno</td><td>要求通番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykjyoutai</td><td>契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykjyoutai C_Kykjyoutai}</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yuukousyoumetukbn</td><td>有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukousyoumetuKbn C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>tsntuukasyu</td><td>通算用通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>tsnyousibous</td><td>通算用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnyouitijip</td><td>通算用一時払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsnyounkgns</td><td>通算用年金原資</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sntkhoukbn</td><td>選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkhouKbn C_SntkhouKbn}</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kykhhkndouhyouji</td><td>契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ttdktyuuikbn1</td><td>手続注意区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn2</td><td>手続注意区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn3</td><td>手続注意区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn4</td><td>手続注意区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn5</td><td>手続注意区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrtkykumukbn</td><td>介護前払特約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pyennykntkykumukbn</td><td>保険料円入金特約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsnyennyknkgk</td><td>通算用円入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>skjmosno</td><td>新契約時申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>houteityotkseisyouhnhyj</td><td>法定貯蓄性商品表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn C_HouteiTyotkseiSyouhnHyjKbn}</td></tr>
 *  <tr><td>seiritujitrhkjikakkbn</td><td>成立時取引時確認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrhkjiKakKbn C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TjtIdouNyKhItjhzn
 * @see     GenBT_TjtIdouNyKhItjhzn
 * @see     QBT_TjtIdouNyKhItjhzn
 * @see     GenQBT_TjtIdouNyKhItjhzn
 */
public class PKBT_TjtIdouNyKhItjhzn extends AbstractExDBPrimaryKey<BT_TjtIdouNyKhItjhzn, PKBT_TjtIdouNyKhItjhzn> {

    private static final long serialVersionUID = 1L;

    public PKBT_TjtIdouNyKhItjhzn() {
    }

    public PKBT_TjtIdouNyKhItjhzn(String pSyono, Integer pRenno3keta) {
        syono = pSyono;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_TjtIdouNyKhItjhzn> getEntityClass() {
        return BT_TjtIdouNyKhItjhzn.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}