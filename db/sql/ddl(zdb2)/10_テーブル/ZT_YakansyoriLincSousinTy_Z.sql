CREATE TABLE ZT_YakansyoriLincSousinTy_Z (
     ztydatakbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）データ区分 */
     ztyrecordsyubetukbn                                VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）レコード種別区分 */
     ztyhenkoutype                                      VARCHAR     (1)                                                                 ,  /* （中継用）変更タイプ */
     ztysyorikekkacd                                    VARCHAR     (1)                                                                 ,  /* （中継用）処理結果コード */
     ztysyorikekkaerrjiyuu                              VARCHAR     (2)                                                                 ,  /* （中継用）処理結果エラー事由 */
     ztysyorikekkaerrno                                 VARCHAR     (3)                                                                 ,  /* （中継用）処理結果エラー項番 */
     ztynayoserecordsuu                                 VARCHAR     (3)                                                                 ,  /* （中継用）名寄せレコード数 */
     ztykanyuusyano                                     VARCHAR     (12)                                                                ,  /* （中継用）加入者番号 */
     ztykyoukaisiyouknnm                                VARCHAR     (32)                                                                ,  /* （中継用）協会使用カナ氏名 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyhhknseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）被保険者生年月日 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztykyksyhhknsydouituhyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）契約者被保険者同一表示 */
     ztysousinmotokaisyacd                              VARCHAR     (2)                                                                 ,  /* （中継用）送信元会社コード */
     ztyhhknadrkn                                       VARCHAR     (30)                                                                ,  /* （中継用）被保険者住所（カナ） */
     ztysiginyuintkykntgkstr                            VARCHAR     (5)                                                                 ,  /* （中継用）災害入院特約日額（文字列） */
     ztysppinyuintkykntgkstr                            VARCHAR     (5)                                                                 ,  /* （中継用）疾病入院特約日額（文字列） */
     ztysijnbyutkykntgkstr                              VARCHAR     (5)                                                                 ,  /* （中継用）成人病特約日額（文字列） */
     ztysonotatokuyakuntgkstr                           VARCHAR     (5)                                                                 ,  /* （中継用）その他特約日額（文字列） */
     ztytrkmousideymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）登録申出年月日 */
     ztylincsyoriymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）ＬＩＮＣ処理年月日 */
     ztyyuyusiyouknnm                                   VARCHAR     (32)                                                                ,  /* （中継用）住友使用カナ氏名 */
     ztykykkanrino                                      VARCHAR     (40)                                                      NOT NULL  ,  /* （中継用）契約管理番号 */
     ztyhozenymd                                        VARCHAR     (8)                                                                 ,  /* （中継用）保全年月日 */
     ztykykknnm                                         VARCHAR     (42)                                                                ,  /* （中継用）契約者カナ氏名 */
     ztyhutuusbsstr                                     VARCHAR     (10)                                                                ,  /* （中継用）普通死亡保険金額（文字列） */
     ztysgsbstr                                         VARCHAR     (10)                                                                ,  /* （中継用）災害死亡保険金額（文字列） */
     ztykakusyasiyouran                                 VARCHAR     (40)                                                                ,  /* （中継用）各社使用欄 */
     ztymousideflg                                      VARCHAR     (1)                                                                 ,  /* （中継用）申出フラグ */
     ztymousideflgsetymd                                VARCHAR     (8)                                                                 ,  /* （中継用）申出フラグ設定年月日 */
     ztymousideflgkaijyoymd                             VARCHAR     (8)                                                                 ,  /* （中継用）申出フラグ解除年月日 */
     ztyjgyhknflg                                       VARCHAR     (1)                                                                 ,  /* （中継用）事業保険フラグ */
     ztytnknflg                                         VARCHAR     (1)                                                                 ,  /* （中継用）転換フラグ */
     ztykyksyaseikbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約者性別区分 */
     ztykyksyaseiymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）契約者生年月日 */
     ztykykadrkn                                        VARCHAR     (30)                                                                ,  /* （中継用）契約者住所（カナ） */
     ztyyobiv17                                         VARCHAR     (17)                                                                ,  /* （中継用）予備項目Ｖ１７ */
     ztyknjhhknmei30                                    VARCHAR     (62)                                                                ,  /* （中継用）漢字被保険者名（３０桁） */
     ztykjkyknm30                                       VARCHAR     (62)                                                                ,  /* （中継用）漢字契約者名（３０桁） */
     zty15sai1000manflg                                 VARCHAR     (1)                                                                 ,  /* （中継用）１５歳未満１０００万超フラグ */
     ztykjhngflg                                        VARCHAR     (1)                                                                 ,  /* （中継用）漢字範囲外フラグ */
     ztykykytymd                                        VARCHAR     (8)                                                                 ,  /* （中継用）契約予定年月日 */
     ztyhozenytymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）保全予定年月日 */
     ztyyobiv62                                         VARCHAR     (62)                                                                ,  /* （中継用）予備項目Ｖ６２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_YakansyoriLincSousinTy_Z ADD CONSTRAINT PK_YakansyoriLincSousinTy PRIMARY KEY (
     ztyrecordsyubetukbn                                      , /* （中継用）レコード種別区分 */
     ztykykkanrino                                              /* （中継用）契約管理番号 */
) ;
