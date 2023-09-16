package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.mapping.GenHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.GenQHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.QHW_SyuHukugouSikkanZhkWk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 主契約複合疾患増幅ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_SyuHukugouSikkanZhkWk}</td><td colspan="3">主契約複合疾患増幅ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknnendo hknnendo}</td><td>保険年度</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ijitoukeidaihyousyurui</td><td>医事統計用代表種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknendo</td><td>契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>kykage</td><td>加入年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>toutatunenrei</td><td>到達年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>atukaibetu</td><td>扱別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ijitoukeisinsahouhou</td><td>医事統計用診査方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ketteikekkaa</td><td>決定結果Ａ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sibousrank</td><td>死亡Ｓランク</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jissituhosyousrank</td><td>実質保障Ｓランク</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sirajikykkbn</td><td>白地契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SirajiKykKbn C_SirajiKykKbn}</td></tr>
 *  <tr><td>hrkhouhoukbn</td><td>払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ijitoukeihokensyuruikbn</td><td>医事統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiHokensyuruiKbn C_IjitoukeiHokensyuruiKbn}</td></tr>
 *  <tr><td>daisiincd</td><td>大死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyuusiincd</td><td>中死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siincd</td><td>死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenreihousikikbn</td><td>年令方式区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkntodouhukencd</td><td>被保険者都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>botaisisyaeigyouhonbu</td><td>母体支社営業本部</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisyaeigyoubu</td><td>支社営業部</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aatsukaishasoshikicd</td><td>Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnensyuukbn</td><td>被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NensyuuKbn C_NensyuuKbn}</td></tr>
 *  <tr><td>hanbaikeirokbn</td><td>販売経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkiagcd</td><td>取扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuudairitenatkikeitaikbn</td><td>募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn C_BosyuuDairitenAtkiKeitaiKbn}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hrktuukasyu</td><td>払込通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jyudkaigomeharaitkhukaumu</td><td>重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ijitoukeizennoukbn</td><td>医事統計用前納区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiZennouKbn C_IjitoukeiZennouKbn}</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ijitoukeitikshrtkykkbn</td><td>医事統計用定期支払特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiTikShrTkykKbn C_IjitoukeiTikShrTkykKbn}</td></tr>
 *  <tr><td>ijitoukeikeikan</td><td>医事統計用経過Ｎ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ijitoukeisiboun</td><td>医事統計用死亡Ｎ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ijitoukeikeikas</td><td>医事統計用経過Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ijitoukeisibous</td><td>医事統計用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HW_SyuHukugouSikkanZhkWk
 * @see     GenHW_SyuHukugouSikkanZhkWk
 * @see     QHW_SyuHukugouSikkanZhkWk
 * @see     GenQHW_SyuHukugouSikkanZhkWk
 */
public class PKHW_SyuHukugouSikkanZhkWk extends AbstractExDBPrimaryKey<HW_SyuHukugouSikkanZhkWk, PKHW_SyuHukugouSikkanZhkWk> {

    private static final long serialVersionUID = 1L;

    public PKHW_SyuHukugouSikkanZhkWk() {
    }

    public PKHW_SyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo) {
        syono = pSyono;
        hknnendo = pHknnendo;
    }

    @Transient
    @Override
    public Class<HW_SyuHukugouSikkanZhkWk> getEntityClass() {
        return HW_SyuHukugouSikkanZhkWk.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer hknnendo;

    public Integer getHknnendo() {
        return hknnendo;
    }

    public void setHknnendo(Integer pHknnendo) {
        hknnendo = pHknnendo;
    }

}