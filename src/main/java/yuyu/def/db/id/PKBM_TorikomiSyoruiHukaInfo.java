package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.mapping.GenBM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.meta.GenQBM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.meta.QBM_TorikomiSyoruiHukaInfo;

/**
 * 取込書類付加情報マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TorikomiSyoruiHukaInfo}</td><td colspan="3">取込書類付加情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruitorikomihoukbn</td><td>書類取込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiTorikomiHouKbn C_SyoruiTorikomiHouKbn}</td></tr>
 *  <tr><td>kouteisakuseikeiki</td><td>工程作成契機</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouteiSakuseiKeikiKbn C_KouteiSakuseiKeikiKbn}</td></tr>
 *  <tr><td>qrcodetaikeikbn</td><td>QRコード体系区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_QrCodeTaikeiKbn C_QrCodeTaikeiKbn}</td></tr>
 *  <tr><td>ttykknryouhi</td><td>到着予定管理要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>hozonKikan</td><td>保存期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>skeijimukbn</td><td>新契約事務区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkeijimuKbn C_SkeijimuKbn}</td></tr>
 *  <tr><td>qrsealumukbn</td><td>QRシール用紙有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>imagegazoukakbn</td><td>イメージ画像化区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ImagegazoukaKbn C_ImagegazoukaKbn}</td></tr>
 * </table>
 * @see     BM_TorikomiSyoruiHukaInfo
 * @see     GenBM_TorikomiSyoruiHukaInfo
 * @see     QBM_TorikomiSyoruiHukaInfo
 * @see     GenQBM_TorikomiSyoruiHukaInfo
 */
public class PKBM_TorikomiSyoruiHukaInfo extends AbstractExDBPrimaryKey<BM_TorikomiSyoruiHukaInfo, PKBM_TorikomiSyoruiHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKBM_TorikomiSyoruiHukaInfo() {
    }

    public PKBM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    @Transient
    @Override
    public Class<BM_TorikomiSyoruiHukaInfo> getEntityClass() {
        return BM_TorikomiSyoruiHukaInfo.class;
    }

    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

}