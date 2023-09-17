package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）アクセスログ（日次）（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzAccessLogDailyDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzAccessLogDailyDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）ログＩＤ")
    private String ifcLogid;

    public String getIfcLogid() {
        return ifcLogid;
    }

    public void setIfcLogid(String pIfcLogid) {
        ifcLogid = pIfcLogid;
    }

    @Column(order = 2, label = "（ＩＦｃ）アクセスログ出力時刻")
    private String ifcTimestamp;

    public String getIfcTimestamp() {
        return ifcTimestamp;
    }

    public void setIfcTimestamp(String pIfcTimestamp) {
        ifcTimestamp = pIfcTimestamp;
    }

    @Column(order = 3, label = "（ＩＦｃ）処理ユーザーＩＤ")
    private String ifcSyoriuserid;

    public String getIfcSyoriuserid() {
        return ifcSyoriuserid;
    }

    public void setIfcSyoriuserid(String pIfcSyoriuserid) {
        ifcSyoriuserid = pIfcSyoriuserid;
    }

    @Column(order = 4, label = "（ＩＦｃ）ＩＰアドレス")
    private String ifcIpaddress;

    public String getIfcIpaddress() {
        return ifcIpaddress;
    }

    public void setIfcIpaddress(String pIfcIpaddress) {
        ifcIpaddress = pIfcIpaddress;
    }

    @Column(order = 5, label = "（ＩＦｃ）セッションＩＤ")
    private String ifcSessionid;

    public String getIfcSessionid() {
        return ifcSessionid;
    }

    public void setIfcSessionid(String pIfcSessionid) {
        ifcSessionid = pIfcSessionid;
    }

    @Column(order = 6, label = "（ＩＦｃ）トランザクションＩＤ")
    private String ifcTransactionid;

    public String getIfcTransactionid() {
        return ifcTransactionid;
    }

    public void setIfcTransactionid(String pIfcTransactionid) {
        ifcTransactionid = pIfcTransactionid;
    }

    @Column(order = 7, label = "（ＩＦｃ）ログ種別コード")
    private String ifcLogkindcd;

    public String getIfcLogkindcd() {
        return ifcLogkindcd;
    }

    public void setIfcLogkindcd(String pIfcLogkindcd) {
        ifcLogkindcd = pIfcLogkindcd;
    }

    @Column(order = 8, label = "（ＩＦｃ）サブシステムＩＤ")
    private String ifcSubsystemid;

    public String getIfcSubsystemid() {
        return ifcSubsystemid;
    }

    public void setIfcSubsystemid(String pIfcSubsystemid) {
        ifcSubsystemid = pIfcSubsystemid;
    }

    @Column(order = 9, label = "（ＩＦｃ）カテゴリＩＤ")
    private String ifcCategoryid;

    public String getIfcCategoryid() {
        return ifcCategoryid;
    }

    public void setIfcCategoryid(String pIfcCategoryid) {
        ifcCategoryid = pIfcCategoryid;
    }

    @Column(order = 10, label = "（ＩＦｃ）機能ＩＤ")
    private String ifcKinouid;

    public String getIfcKinouid() {
        return ifcKinouid;
    }

    public void setIfcKinouid(String pIfcKinouid) {
        ifcKinouid = pIfcKinouid;
    }

    @Column(order = 11, label = "（ＩＦｃ）端末タイプ")
    private String ifcTanmatutype;

    public String getIfcTanmatutype() {
        return ifcTanmatutype;
    }

    public void setIfcTanmatutype(String pIfcTanmatutype) {
        ifcTanmatutype = pIfcTanmatutype;
    }

    @Column(order = 12, label = "（ＩＦｃ）物理組織コード")
    private String ifcButsurisosikicd;

    public String getIfcButsurisosikicd() {
        return ifcButsurisosikicd;
    }

    public void setIfcButsurisosikicd(String pIfcButsurisosikicd) {
        ifcButsurisosikicd = pIfcButsurisosikicd;
    }

    @Column(order = 13, label = "（ＩＦｃ）論理組織コード")
    private String ifcRonrisosikicd;

    public String getIfcRonrisosikicd() {
        return ifcRonrisosikicd;
    }

    public void setIfcRonrisosikicd(String pIfcRonrisosikicd) {
        ifcRonrisosikicd = pIfcRonrisosikicd;
    }

    @Column(order = 14, label = "（ＩＦｃ）端末状態表示")
    private String ifcTanmatujyoutaihyouji;

    public String getIfcTanmatujyoutaihyouji() {
        return ifcTanmatujyoutaihyouji;
    }

    public void setIfcTanmatujyoutaihyouji(String pIfcTanmatujyoutaihyouji) {
        ifcTanmatujyoutaihyouji = pIfcTanmatujyoutaihyouji;
    }

    @Column(order = 15, label = "（ＩＦｃ）ログデータ")
    private String ifcLogdata;

    public String getIfcLogdata() {
        return ifcLogdata;
    }

    public void setIfcLogdata(String pIfcLogdata) {
        ifcLogdata = pIfcLogdata;
    }

    @Column(order = 16, label = "（ＩＦｃ）詳細ログ件数")
    private String ifcSyousaikensuu;

    public String getIfcSyousaikensuu() {
        return ifcSyousaikensuu;
    }

    public void setIfcSyousaikensuu(String pIfcSyousaikensuu) {
        ifcSyousaikensuu = pIfcSyousaikensuu;
    }

    @Column(order = 17, label = "（ＩＦｃ）詳細ログ枝番号")
    private String ifcSyousaiedano;

    public String getIfcSyousaiedano() {
        return ifcSyousaiedano;
    }

    public void setIfcSyousaiedano(String pIfcSyousaiedano) {
        ifcSyousaiedano = pIfcSyousaiedano;
    }

    @Column(order = 18, label = "（ＩＦｃ）ログ詳細データ")
    private String ifcLogsyousaidata;

    public String getIfcLogsyousaidata() {
        return ifcLogsyousaidata;
    }

    public void setIfcLogsyousaidata(String pIfcLogsyousaidata) {
        ifcLogsyousaidata = pIfcLogsyousaidata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
