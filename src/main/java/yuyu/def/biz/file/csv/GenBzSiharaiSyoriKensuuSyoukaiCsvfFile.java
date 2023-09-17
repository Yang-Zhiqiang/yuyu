package yuyu.def.biz.file.csv;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）保険金給付金支払処理件数照会ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSiharaiSyoriKensuuSyoukaiCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSiharaiSyoriKensuuSyoukaiCsvfFile() {
    }

    @Column(order = 1, label = "サブシステム")
    private String ifcSubsystem;

    public String getIfcSubsystem() {
        return ifcSubsystem;
    }

    public void setIfcSubsystem(String pIfcSubsystem) {
        ifcSubsystem = pIfcSubsystem;
    }

    @Column(order = 2, label = "処理日")
    private String ifcSyoriymd2;

    public String getIfcSyoriymd2() {
        return ifcSyoriymd2;
    }

    public void setIfcSyoriymd2(String pIfcSyoriymd2) {
        ifcSyoriymd2 = pIfcSyoriymd2;
    }

    @Column(order = 3, label = "事務手続名")
    private String ifcJimutetuzukinm;

    public String getIfcJimutetuzukinm() {
        return ifcJimutetuzukinm;
    }

    public void setIfcJimutetuzukinm(String pIfcJimutetuzukinm) {
        ifcJimutetuzukinm = pIfcJimutetuzukinm;
    }

    @Column(order = 4, label = "ワークフロータスク名")
    private String ifcWorkflowTskNm;

    public String getIfcWorkflowTskNm() {
        return ifcWorkflowTskNm;
    }

    public void setIfcWorkflowTskNm(String pIfcWorkflowTskNm) {
        ifcWorkflowTskNm = pIfcWorkflowTskNm;
    }

    @Column(order = 5, label = "ユーザーＩＤ")
    private String ifcUserId;

    public String getIfcUserId() {
        return ifcUserId;
    }

    public void setIfcUserId(String pIfcUserId) {
        ifcUserId = pIfcUserId;
    }

    @Column(order = 6, label = "ユーザー名")
    private String ifcUsernm;

    public String getIfcUsernm() {
        return ifcUsernm;
    }

    public void setIfcUsernm(String pIfcUsernm) {
        ifcUsernm = pIfcUsernm;
    }

    @Column(order = 7, label = "前日残件数")
    private String ifcZenjituzanKensuu;

    public String getIfcZenjituzanKensuu() {
        return ifcZenjituzanKensuu;
    }

    public void setIfcZenjituzanKensuu(String pIfcZenjituzanKensuu) {
        ifcZenjituzanKensuu = pIfcZenjituzanKensuu;
    }

    @Column(order = 8, label = "残件数")
    private String ifcZanKensuu;

    public String getIfcZanKensuu() {
        return ifcZanKensuu;
    }

    public void setIfcZanKensuu(String pIfcZanKensuu) {
        ifcZanKensuu = pIfcZanKensuu;
    }

    @Column(order = 9, label = "完了件数")
    private String ifcKanryoKensuu;

    public String getIfcKanryoKensuu() {
        return ifcKanryoKensuu;
    }

    public void setIfcKanryoKensuu(String pIfcKanryoKensuu) {
        ifcKanryoKensuu = pIfcKanryoKensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
