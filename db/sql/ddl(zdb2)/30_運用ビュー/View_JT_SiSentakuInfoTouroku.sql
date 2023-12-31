CREATE VIEW JT_SiSentakuInfoTouroku AS SELECT
     syono ,         /* 証券番号 */
     renno ,         /* 連番 */
     syoriYmd ,         /* 処理年月日 */
     huho2kykno ,         /* 普保Ⅱ契約番号 */
     huho2kyknokbn ,         /* 普保Ⅱ契約番号区分 */
     syouhncd ,         /* 商品コード */
     sntkinfokankeisyakbn ,         /* 選択情報関係者区分 */
     taisyounmkn ,         /* 対象者氏名（カナ） */
     taisyounmkj ,         /* 対象者氏名（漢字） */
     taisyouseiymd ,         /* 対象者生年月日 */
     taisyouseibetu ,         /* 対象者性別 */
     dakuhiketnaiyouumukbn ,         /* 諾否決定内容有無区分 */
     kktnaiyouumukbn ,         /* 告知内容有無区分 */
     kijinaiyouumukbn ,         /* 記事内容有無区分 */
     mrumukbn ,         /* ＭＲ有無区分 */
     koudosyougaiumukbn ,         /* 高度障害有無区分 */
     torikaijoumukbn ,         /* 取消解除有無区分 */
     kdsssiharaijyoutaikbn ,         /* 高度障害Ｓ支払状態区分 */
     kdsssiharaiymd ,         /* 高度障害Ｓ支払年月日 */
     kdsymd ,         /* 高度障害年月日 */
     kdssiharaisosikicd ,         /* 高度障害支払組織コード */
     syorizumiflg ,         /* 処理済フラグ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SiSentakuInfoTouroku_Z;