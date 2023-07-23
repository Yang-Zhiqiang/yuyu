package yuyu.infr.report.swakreport;

/**
 * 帳票データソースのインターフェースです。
 * SWAK帳票基盤のデータソースは全てこのインターフェースの実装でなければなりません。
 */
public interface IReportDataSouce<T extends IReportDataSouceBean> extends Iterable<T> {
}
