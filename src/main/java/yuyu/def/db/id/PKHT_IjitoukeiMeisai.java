package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.mapping.GenHT_IjitoukeiMeisai;
import yuyu.def.db.meta.GenQHT_IjitoukeiMeisai;
import yuyu.def.db.meta.QHT_IjitoukeiMeisai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 医事統計明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_IjitoukeiMeisai}</td><td colspan="3">医事統計明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrymd</td><td>支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>idousyoriymd</td><td>異動処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sntkhoukbn</td><td>選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkhouKbn C_SntkhouKbn}</td></tr>
 *  <tr><td>kokutikbn</td><td>告知区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KokutiKbn C_KokutiKbn}</td></tr>
 *  <tr><td>skeijimukbn</td><td>新契約事務区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkeijimuKbn C_SkeijimuKbn}</td></tr>
 *  <tr><td>sirajikykkbn</td><td>白地契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SirajiKykKbn C_SirajiKykKbn}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>haitoukinuketorihoukbn</td><td>配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinuketorihouKbn C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aatsukaishasoshikicd</td><td>Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aatukaikojincd</td><td>Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkiagcd</td><td>取扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuudairitenatkikeitaikbn</td><td>募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn C_BosyuuDairitenAtkiKeitaiKbn}</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknyno</td><td>被保険者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkntodouhukencd</td><td>被保険者都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnensyuukbn</td><td>被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NensyuuKbn C_NensyuuKbn}</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sintyou</td><td>身長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taijyuu</td><td>体重</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kituenkbn</td><td>喫煙区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KituenKbn C_KituenKbn}</td></tr>
 *  <tr><td>kituenhon</td><td>喫煙本数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hrktuukasyu</td><td>払込通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>seitoukihons</td><td>正当基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seitoukihonsmanen</td><td>正当基本Ｓ（万円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syutkp</td><td>主契約・特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syutkpmanen</td><td>主契約・特約Ｐ（万円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>imustiyusbus</td><td>医務査定用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>imustiyusbusmanen</td><td>医務査定用死亡Ｓ（万円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansantkykwsrate</td><td>円換算適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoubyoucd1</td><td>傷病コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyoucd2</td><td>傷病コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dakuhiktkekkacd</td><td>諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketkekkacd C_Ketkekkacd}</td></tr>
 *  <tr><td>dakuhiketsyacd</td><td>諾否決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syksbyensitihsyutkhkkbn</td><td>初期死亡時円換算最低保証特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>jyudkaigomehrtkhkkbn</td><td>重度介護前払特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>symtgenincd</td><td>消滅原因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>siincd</td><td>死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ijitoukeikaijyokbn</td><td>医事統計解除区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiKaijyoKbn C_IjitoukeiKaijyoKbn}</td></tr>
 *  <tr><td>sysnikoujiym</td><td>終身移行時年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>ijitoukeizennoukbn</td><td>医事統計用前納区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiZennouKbn C_IjitoukeiZennouKbn}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>jissituhosyous</td><td>実質保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jissituhosyousmanen</td><td>実質保障Ｓ（万円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ijitoukeitikshrtkykkbn</td><td>医事統計用定期支払特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiTikShrTkykKbn C_IjitoukeiTikShrTkykKbn}</td></tr>
 *  <tr><td>teikisiharaikin</td><td>定期支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teikisiharaikinmanen</td><td>定期支払金（万円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_IjitoukeiMeisai
 * @see     GenHT_IjitoukeiMeisai
 * @see     QHT_IjitoukeiMeisai
 * @see     GenQHT_IjitoukeiMeisai
 */
public class PKHT_IjitoukeiMeisai extends AbstractExDBPrimaryKey<HT_IjitoukeiMeisai, PKHT_IjitoukeiMeisai> {

    private static final long serialVersionUID = 1L;

    public PKHT_IjitoukeiMeisai() {
    }

    public PKHT_IjitoukeiMeisai(String pSyono, Integer pRenno8keta) {
        syono = pSyono;
        renno8keta = pRenno8keta;
    }

    @Transient
    @Override
    public Class<HT_IjitoukeiMeisai> getEntityClass() {
        return HT_IjitoukeiMeisai.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno8keta;

    public Integer getRenno8keta() {
        return renno8keta;
    }

    public void setRenno8keta(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

}