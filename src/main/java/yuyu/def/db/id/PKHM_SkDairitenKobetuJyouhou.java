package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.mapping.GenHM_SkDairitenKobetuJyouhou;
import yuyu.def.db.meta.GenQHM_SkDairitenKobetuJyouhou;
import yuyu.def.db.meta.QHM_SkDairitenKobetuJyouhou;

/**
 * 代理店個別情報マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkDairitenKobetuJyouhou}</td><td colspan="3">代理店個別情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenRnrkhouKbn</td><td>代理店連絡方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtenRnrkhouKbn C_DrtenRnrkhouKbn}</td></tr>
 *  <tr><td>utdskknnm1kj</td><td>打出機関名１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>utdskknnm2kj</td><td>打出機関名２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykntratkikbn</td><td>入金取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NykntratkiKbn C_NykntratkiKbn}</td></tr>
 *  <tr><td>trksskssouhukbn</td><td>取消請求書送付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrksskssouhuKbn C_TrksskssouhuKbn}</td></tr>
 *  <tr><td>tkhjnkinyuucd</td><td>特定関係法人金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtentrkno</td><td>代理店登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcdcheckyouhi</td><td>ＣＩＦコードチェック要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>cifcdsiteiketasuu</td><td>ＣＩＦコード指定桁数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcdmaezeroumeyouhi</td><td>ＣＩＦコード前ゼロ埋め要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>kosymd</td><td>更新日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SkDairitenKobetuJyouhou
 * @see     GenHM_SkDairitenKobetuJyouhou
 * @see     QHM_SkDairitenKobetuJyouhou
 * @see     GenQHM_SkDairitenKobetuJyouhou
 */
public class PKHM_SkDairitenKobetuJyouhou extends AbstractExDBPrimaryKey<HM_SkDairitenKobetuJyouhou, PKHM_SkDairitenKobetuJyouhou> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkDairitenKobetuJyouhou() {
    }

    public PKHM_SkDairitenKobetuJyouhou(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    @Transient
    @Override
    public Class<HM_SkDairitenKobetuJyouhou> getEntityClass() {
        return HM_SkDairitenKobetuJyouhou.class;
    }

    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

}