CREATE TABLE ZT_OnlineLincSousinRn_Z (
     zrndatakbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分 */
     zrnrecordsyubetukbn                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）レコード種別区分 */
     zrnhenkoutype                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）変更タイプ */
     zrnsyorikekkacd                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）処理結果コード */
     zrnsyorikekkaerrjiyuu                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）処理結果エラー事由 */
     zrnsyorikekkaerrno                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）処理結果エラー項番 */
     zrnnayoserecordsuu                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）名寄せレコード数 */
     zrnkanyuusyano                                     CHAR        (12)                                                      NOT NULL  ,  /* （連携用）加入者番号 */
     zrnkyoukaisiyouknnm                                CHAR        (32)                                                      NOT NULL  ,  /* （連携用）協会使用カナ氏名 */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnhhknseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）被保険者生年月日 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnkyksyhhknsydouituhyouji                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者被保険者同一表示 */
     zrnsousinmotokaisyacd                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）送信元会社コード */
     zrnhhknadrkn                                       CHAR        (30)                                                      NOT NULL  ,  /* （連携用）被保険者住所（カナ） */
     zrnsiginyuintkykntgkstr                            CHAR        (5)                                                       NOT NULL  ,  /* （連携用）災害入院特約日額（文字列） */
     zrnsppinyuintkykntgkstr                            CHAR        (5)                                                       NOT NULL  ,  /* （連携用）疾病入院特約日額（文字列） */
     zrnsijnbyutkykntgkstr                              CHAR        (5)                                                       NOT NULL  ,  /* （連携用）成人病特約日額（文字列） */
     zrnsonotatokuyakuntgkstr                           CHAR        (5)                                                       NOT NULL  ,  /* （連携用）その他特約日額（文字列） */
     zrntrkmousideymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）登録申出年月日 */
     zrnlincsyoriymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＬＩＮＣ処理年月日 */
     zrnyuyusiyouknnm                                   CHAR        (32)                                                      NOT NULL  ,  /* （連携用）住友使用カナ氏名 */
     zrnkykkanrino                                      CHAR        (40)                                                      NOT NULL  ,  /* （連携用）契約管理番号 */
     zrnhozenymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）保全年月日 */
     zrnkykknnm                                         CHAR        (42)                                                      NOT NULL  ,  /* （連携用）契約者カナ氏名 */
     zrnhutuusbsstr                                     CHAR        (10)                                                      NOT NULL  ,  /* （連携用）普通死亡保険金額 */
     zrnsgsbstr                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）災害死亡保険金額 */
     zrnkakusyasiyouran                                 CHAR        (40)                                                      NOT NULL  ,  /* （連携用）各社使用欄 */
     zrnmousideflg                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申出フラグ */
     zrnmousideflgsetymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申出フラグ設定年月日 */
     zrnmousideflgkaijyoymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申出フラグ解除年月日 */
     zrnjgyhknflg                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）事業保険フラグ */
     zrntnknflg                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換フラグ */
     zrnkyksyaseikbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者性別区分 */
     zrnkyksyaseiymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者生年月日 */
     zrnkykadrkn                                        CHAR        (30)                                                      NOT NULL  ,  /* （連携用）契約者住所（カナ） */
     zrnyobiv17                                         CHAR        (17)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１７ */
     zrnknjhhknmei30                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）漢字被保険者名（３０桁） */
     zrnkjkyknm30                                       GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）漢字契約者名（３０桁） */
     zrn15sai1000manflg                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）１５歳未満１０００万超フラグ */
     zrnkjhngflg                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）漢字範囲外フラグ */
     zrnkykytymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約予定年月日 */
     zrnhozenytymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）保全予定年月日 */
     zrnyobiv62                                         CHAR        (62)                                                      NOT NULL     /* （連携用）予備項目Ｖ６２ */
)
;

ALTER TABLE ZT_OnlineLincSousinRn_Z ADD CONSTRAINT PK_OnlineLincSousinRn PRIMARY KEY (
     zrnrecordsyubetukbn                                      , /* （連携用）レコード種別区分 */
     zrnkykkanrino                                              /* （連携用）契約管理番号 */
) ;
