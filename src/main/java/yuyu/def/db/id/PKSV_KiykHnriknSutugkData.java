package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_KiykHnriknSutugkData;
import yuyu.def.db.mapping.GenSV_KiykHnriknSutugkData;
import yuyu.def.db.meta.GenQSV_KiykHnriknSutugkData;
import yuyu.def.db.meta.QSV_KiykHnriknSutugkData;

/**
 * 解約返戻金相当額情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_KiykHnriknSutugkData}</td><td colspan="3">解約返戻金相当額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknkknsmnkbn</td><td>保険期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkknsmnkbn</td><td>払込期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>katakbn</td><td>型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn</td><td>給付限度型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhrtype</td><td>解約返戻金支払タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kaiyakuhrtype C_Kaiyakuhrtype}</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 * </table>
 * @see     SV_KiykHnriknSutugkData
 * @see     GenSV_KiykHnriknSutugkData
 * @see     QSV_KiykHnriknSutugkData
 * @see     GenQSV_KiykHnriknSutugkData
 */
public class PKSV_KiykHnriknSutugkData extends AbstractExDBPrimaryKey<SV_KiykHnriknSutugkData, PKSV_KiykHnriknSutugkData> {

    private static final long serialVersionUID = 1L;

    public PKSV_KiykHnriknSutugkData() {
    }

    public PKSV_KiykHnriknSutugkData(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

    @Transient
    @Override
    public Class<SV_KiykHnriknSutugkData> getEntityClass() {
        return SV_KiykHnriknSutugkData.class;
    }

    private Integer renno8keta;

    public Integer getRenno8keta() {
        return renno8keta;
    }

    public void setRenno8keta(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

}