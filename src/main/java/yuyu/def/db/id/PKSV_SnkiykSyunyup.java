package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.mapping.GenSV_SnkiykSyunyup;
import yuyu.def.db.meta.GenQSV_SnkiykSyunyup;
import yuyu.def.db.meta.QSV_SnkiykSyunyup;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約収入Ｐ統計情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SnkiykSyunyup}</td><td colspan="3">新契約収入Ｐ統計情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seiritukbn</td><td>成立区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeirituKbn C_SeirituKbn}</td></tr>
 *  <tr><td>srsyoriymd</td><td>成立処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seisekiym</td><td>成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>skeikeijyouym</td><td>新契約計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kykkbn</td><td>契約者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykKbn C_KykKbn}</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>hyouteip</td><td>表定Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hrktuukasyu</td><td>払込通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>fstphrkgk</td><td>初回Ｐ払込必要額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknen</td><td>契約者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>heijyunp</td><td>平準払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennoumousideumu</td><td>前納申出有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zennoujyuutoup</td><td>前納年払充当Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tratkiagcd</td><td>取扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd</td><td>代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teikishrtkykhukaumu</td><td>定期支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sisuuhaibunwarikbn</td><td>指数部分配分割合区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumitatekinHaibunWariKbn C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>sisuukbn</td><td>指数区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sisuukbn C_Sisuukbn}</td></tr>
 *  <tr><td>zennoukikan</td><td>前納期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_SnkiykSyunyup
 * @see     GenSV_SnkiykSyunyup
 * @see     QSV_SnkiykSyunyup
 * @see     GenQSV_SnkiykSyunyup
 */
public class PKSV_SnkiykSyunyup extends AbstractExDBPrimaryKey<SV_SnkiykSyunyup, PKSV_SnkiykSyunyup> {

    private static final long serialVersionUID = 1L;

    public PKSV_SnkiykSyunyup() {
    }

    public PKSV_SnkiykSyunyup(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<SV_SnkiykSyunyup> getEntityClass() {
        return SV_SnkiykSyunyup.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}