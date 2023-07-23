package yuyu.infr.report;

import yuyu.infr.report.swakreport.ReportServicesBean;



/**
 * 帳票作成前処理実装用クラスです。<br />
 * 当クラスは帳票基盤が帳票作成処理を始める前の段階で呼出します。<br />
 * 複数件の帳票サービスビーンを引数にしている場合、その１件毎に実行されます。<br />
 * <br />
 * 当クラス自体は空実装であり、業務層においてサブクラスを作成の上、<br />
 * Moduleクラスで当クラスに対するバインド定義を行なうと、当クラスの代わりにバインドクラスの処理が実行されます。
 *
 */
public class PreCreateReport {

    protected void exec(ReportServicesBean pBean){
        return;
    }
}
