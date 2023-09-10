package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）支社別保険金種類別集計情報レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSsyHkgksyrSykInfoLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiSsyHkgksyrSykInfoLayoutFile() {
    }


    @Column(order = 1, label = "支社コード")
    @NotNull
    private String ifcSisyacd;


    public String getIfcSisyacd() {
        return ifcSisyacd;
    }


    public void setIfcSisyacd(String pIfcSisyacd) {
        ifcSisyacd = pIfcSisyacd;
    }


    @Column(order = 2, label = "支社名")
    @NotNull
    private String ifcSisyanm;


    public String getIfcSisyanm() {
        return ifcSisyanm;
    }


    public void setIfcSisyanm(String pIfcSisyanm) {
        ifcSisyanm = pIfcSisyanm;
    }


    @Column(order = 3, label = "死亡保険金支払件数（円）")
    private Integer ifcSibousshrcount;


    public Integer getIfcSibousshrcount() {
        return ifcSibousshrcount;
    }


    public void setIfcSibousshrcount(Integer pIfcSibousshrcount) {
        ifcSibousshrcount = pIfcSibousshrcount;
    }


    @Column(order = 4, label = "死亡保険金支払金額（円）")
    private String ifcSibousshrgk;


    public String getIfcSibousshrgk() {
        return ifcSibousshrgk;
    }


    public void setIfcSibousshrgk(String pIfcSibousshrgk) {
        ifcSibousshrgk = pIfcSibousshrgk;
    }


    @Column(order = 5, label = "災害死亡保険金支払件数（円）")
    private Integer ifcSaigaisshrcount;


    public Integer getIfcSaigaisshrcount() {
        return ifcSaigaisshrcount;
    }


    public void setIfcSaigaisshrcount(Integer pIfcSaigaisshrcount) {
        ifcSaigaisshrcount = pIfcSaigaisshrcount;
    }


    @Column(order = 6, label = "災害死亡保険金支払金額（円）")
    private String ifcSaigaisshrgk;


    public String getIfcSaigaisshrgk() {
        return ifcSaigaisshrgk;
    }


    public void setIfcSaigaisshrgk(String pIfcSaigaisshrgk) {
        ifcSaigaisshrgk = pIfcSaigaisshrgk;
    }


    @Column(order = 7, label = "死亡保険金支払件数（米ドル）")
    private Integer ifcSibousshrcountusd;


    public Integer getIfcSibousshrcountusd() {
        return ifcSibousshrcountusd;
    }


    public void setIfcSibousshrcountusd(Integer pIfcSibousshrcountusd) {
        ifcSibousshrcountusd = pIfcSibousshrcountusd;
    }


    @Column(order = 8, label = "死亡保険金支払金額（米ドル）")
    private String ifcSibousshrgkusd;


    public String getIfcSibousshrgkusd() {
        return ifcSibousshrgkusd;
    }


    public void setIfcSibousshrgkusd(String pIfcSibousshrgkusd) {
        ifcSibousshrgkusd = pIfcSibousshrgkusd;
    }


    @Column(order = 9, label = "災害死亡保険金支払件数（米ドル）")
    private Integer ifcSaigaisshrcountusd;


    public Integer getIfcSaigaisshrcountusd() {
        return ifcSaigaisshrcountusd;
    }


    public void setIfcSaigaisshrcountusd(Integer pIfcSaigaisshrcountusd) {
        ifcSaigaisshrcountusd = pIfcSaigaisshrcountusd;
    }


    @Column(order = 10, label = "災害死亡保険金支払金額（米ドル）")
    private String ifcSaigaisshrgkusd;


    public String getIfcSaigaisshrgkusd() {
        return ifcSaigaisshrgkusd;
    }


    public void setIfcSaigaisshrgkusd(String pIfcSaigaisshrgkusd) {
        ifcSaigaisshrgkusd = pIfcSaigaisshrgkusd;
    }


    @Column(order = 11, label = "死亡保険金支払件数（豪ドル）")
    private Integer ifcSibousshrcountaud;


    public Integer getIfcSibousshrcountaud() {
        return ifcSibousshrcountaud;
    }


    public void setIfcSibousshrcountaud(Integer pIfcSibousshrcountaud) {
        ifcSibousshrcountaud = pIfcSibousshrcountaud;
    }


    @Column(order = 12, label = "死亡保険金支払金額（豪ドル）")
    private String ifcSibousshrgkaud;


    public String getIfcSibousshrgkaud() {
        return ifcSibousshrgkaud;
    }


    public void setIfcSibousshrgkaud(String pIfcSibousshrgkaud) {
        ifcSibousshrgkaud = pIfcSibousshrgkaud;
    }


    @Column(order = 13, label = "災害死亡保険金支払件数（豪ドル）")
    private Integer ifcSaigaisshrcountaud;


    public Integer getIfcSaigaisshrcountaud() {
        return ifcSaigaisshrcountaud;
    }


    public void setIfcSaigaisshrcountaud(Integer pIfcSaigaisshrcountaud) {
        ifcSaigaisshrcountaud = pIfcSaigaisshrcountaud;
    }


    @Column(order = 14, label = "災害死亡保険金支払金額（豪ドル）")
    private String ifcSaigaisshrgkaud;


    public String getIfcSaigaisshrgkaud() {
        return ifcSaigaisshrgkaud;
    }


    public void setIfcSaigaisshrgkaud(String pIfcSaigaisshrgkaud) {
        ifcSaigaisshrgkaud = pIfcSaigaisshrgkaud;
    }


    @Column(order = 15, label = "死亡保険金支払件数（ユーロ）")
    private Integer ifcSibousshrcounteur;


    public Integer getIfcSibousshrcounteur() {
        return ifcSibousshrcounteur;
    }


    public void setIfcSibousshrcounteur(Integer pIfcSibousshrcounteur) {
        ifcSibousshrcounteur = pIfcSibousshrcounteur;
    }


    @Column(order = 16, label = "死亡保険金支払金額（ユーロ）")
    private String ifcSibousshrgkeur;


    public String getIfcSibousshrgkeur() {
        return ifcSibousshrgkeur;
    }


    public void setIfcSibousshrgkeur(String pIfcSibousshrgkeur) {
        ifcSibousshrgkeur = pIfcSibousshrgkeur;
    }


    @Column(order = 17, label = "災害死亡保険金支払件数（ユーロ）")
    private Integer ifcSaigaisshrcounteur;


    public Integer getIfcSaigaisshrcounteur() {
        return ifcSaigaisshrcounteur;
    }


    public void setIfcSaigaisshrcounteur(Integer pIfcSaigaisshrcounteur) {
        ifcSaigaisshrcounteur = pIfcSaigaisshrcounteur;
    }


    @Column(order = 18, label = "災害死亡保険金支払金額（ユーロ）")
    private String ifcSaigaisshrgkeur;


    public String getIfcSaigaisshrgkeur() {
        return ifcSaigaisshrgkeur;
    }


    public void setIfcSaigaisshrgkeur(String pIfcSaigaisshrgkeur) {
        ifcSaigaisshrgkeur = pIfcSaigaisshrgkeur;
    }


    @Column(order = 19, label = "死亡給付金支払件数（円）")
    private Integer ifcSbkyhknshrcount;


    public Integer getIfcSbkyhknshrcount() {
        return ifcSbkyhknshrcount;
    }


    public void setIfcSbkyhknshrcount(Integer pIfcSbkyhknshrcount) {
        ifcSbkyhknshrcount = pIfcSbkyhknshrcount;
    }


    @Column(order = 20, label = "死亡給付金支払金額（円）")
    private String ifcSbkyhknshrgk;


    public String getIfcSbkyhknshrgk() {
        return ifcSbkyhknshrgk;
    }


    public void setIfcSbkyhknshrgk(String pIfcSbkyhknshrgk) {
        ifcSbkyhknshrgk = pIfcSbkyhknshrgk;
    }


    @Column(order = 21, label = "死亡給付金支払件数（米ドル）")
    private Integer ifcSbkyhknshrcountusd;


    public Integer getIfcSbkyhknshrcountusd() {
        return ifcSbkyhknshrcountusd;
    }


    public void setIfcSbkyhknshrcountusd(Integer pIfcSbkyhknshrcountusd) {
        ifcSbkyhknshrcountusd = pIfcSbkyhknshrcountusd;
    }


    @Column(order = 22, label = "死亡給付金支払金額（米ドル）")
    private String ifcSbkyhknshrgkusd;


    public String getIfcSbkyhknshrgkusd() {
        return ifcSbkyhknshrgkusd;
    }


    public void setIfcSbkyhknshrgkusd(String pIfcSbkyhknshrgkusd) {
        ifcSbkyhknshrgkusd = pIfcSbkyhknshrgkusd;
    }


    @Column(order = 23, label = "死亡給付金支払件数（豪ドル）")
    private Integer ifcSbkyhknshrcountaud;


    public Integer getIfcSbkyhknshrcountaud() {
        return ifcSbkyhknshrcountaud;
    }


    public void setIfcSbkyhknshrcountaud(Integer pIfcSbkyhknshrcountaud) {
        ifcSbkyhknshrcountaud = pIfcSbkyhknshrcountaud;
    }


    @Column(order = 24, label = "死亡給付金支払金額（豪ドル）")
    private String ifcSbkyhknshrgkaud;


    public String getIfcSbkyhknshrgkaud() {
        return ifcSbkyhknshrgkaud;
    }


    public void setIfcSbkyhknshrgkaud(String pIfcSbkyhknshrgkaud) {
        ifcSbkyhknshrgkaud = pIfcSbkyhknshrgkaud;
    }


    @Column(order = 25, label = "死亡給付金支払件数（ユーロ）")
    private Integer ifcSbkyhknshrcounteur;


    public Integer getIfcSbkyhknshrcounteur() {
        return ifcSbkyhknshrcounteur;
    }


    public void setIfcSbkyhknshrcounteur(Integer pIfcSbkyhknshrcounteur) {
        ifcSbkyhknshrcounteur = pIfcSbkyhknshrcounteur;
    }


    @Column(order = 26, label = "死亡給付金支払金額（ユーロ）")
    private String ifcSbkyhknshrgkeur;


    public String getIfcSbkyhknshrgkeur() {
        return ifcSbkyhknshrgkeur;
    }


    public void setIfcSbkyhknshrgkeur(String pIfcSbkyhknshrgkeur) {
        ifcSbkyhknshrgkeur = pIfcSbkyhknshrgkeur;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
