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
import yuyu.def.db.entity.AS_FileServerInfo;
import yuyu.def.db.mapping.GenAS_FileServerInfo;
import yuyu.def.db.meta.GenQAS_FileServerInfo;
import yuyu.def.db.meta.QAS_FileServerInfo;

/**
 * ファイルサーバー情報基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_FileServerInfo}</td><td colspan="3">ファイルサーバー情報基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSetteiNo setteiNo}</td><td>設定番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyouYmdFrom tekiyouYmdFrom}</td><td>適用年月日（自）</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>setteiNm</td><td>設定名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setuzokusakiDomain</td><td>接続先ドメイン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setuzokusakiIpAddress</td><td>接続先ＩＰアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setuzokusakiPortNo</td><td>接続先ポート番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setuzokuUser</td><td>接続ユーザー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setuzokuPassword</td><td>接続先パスワード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>angoukaKbn</td><td>暗号化区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 * </table>
 * @see     AS_FileServerInfo
 * @see     GenAS_FileServerInfo
 * @see     QAS_FileServerInfo
 * @see     GenQAS_FileServerInfo
 */
public class PKAS_FileServerInfo extends AbstractExDBPrimaryKey<AS_FileServerInfo, PKAS_FileServerInfo> {

    private static final long serialVersionUID = 1L;

    public PKAS_FileServerInfo() {
    }

    public PKAS_FileServerInfo(Integer pSetteiNo, BizDate pTekiyouYmdFrom) {
        setteiNo = pSetteiNo;
        tekiyouYmdFrom = pTekiyouYmdFrom;
    }

    @Transient
    @Override
    public Class<AS_FileServerInfo> getEntityClass() {
        return AS_FileServerInfo.class;
    }

    private Integer setteiNo;

    public Integer getSetteiNo() {
        return setteiNo;
    }

    public void setSetteiNo(Integer pSetteiNo) {
        setteiNo = pSetteiNo;
    }
    private BizDate tekiyouYmdFrom;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTekiyouYmdFrom() {
        return tekiyouYmdFrom;
    }

    public void setTekiyouYmdFrom(BizDate pTekiyouYmdFrom) {
        tekiyouYmdFrom = pTekiyouYmdFrom;
    }

}