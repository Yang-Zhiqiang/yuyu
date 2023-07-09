CREATE TABLE ZT_SmbcBosRn_Z (
     zrnseihowebidkbn                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＩＤ区分 */
     zrnseihowebkojincd                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ個人コード */
     zrnseihowebitijihozonhyouji                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ一時保存表示 */
     zrnseihowebsekno                                   DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ設計書番号 */
     zrnseihowebcalckijyunymd                           DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ計算基準年月日 */
     zrnseihowebhhknknnm                                CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者カナ氏名 */
     zrnseihowebhhknkjnm                                GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者漢字氏名 */
     zrnseihowebhhknseiymd                              DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者生年月日 */
     zrnseihowebhhknseikbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者性別区分 */
     zrnseihowebmrhkihontikucd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂマル被基本地区コード */
     zrnseihowebhhknadr                                 GRAPHIC     (124)                                                     NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者住所 */
     zrnseihowebkykknnm                                 CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者カナ氏名 */
     zrnseihowebkykkjnm                                 GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者漢字氏名 */
     zrnseihowebkyksyaseiymd                            DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者生年月日 */
     zrnseihowebkyksyaseikbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者性別区分 */
     zrnseihowebkykkihontikucd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者基本地区コード */
     zrnseihowebkykadr                                  GRAPHIC     (124)                                                     NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者住所 */
     zrnseihowebhknsyuruino                             DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ保険種類番号 */
     zrnseihowebhjkktkbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ報状告知区分 */
     zrnseihowebhknkkn                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ保険期間 */
     zrnseihowebphrkkikn                                DECIMAL     (2)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰ払込期間 */
     zrnseihowebhrkkaisuukbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ払込回数区分 */
     zrnseihowebhrkkeirokbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ払込経路区分 */
     zrnseihowebsdpdkbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＳ建Ｐ建区分 */
     zrnseihowebkihons                                  DECIMAL     (9)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ基本Ｓ */
     zrnseihowebnksyuruikbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ年金種類区分 */
     zrnseihoweblntkkbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＬＮ特約区分 */
     zrnseihowebnkshrarihyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ年金支払特約有表示 */
     zrnseihowebmosno                                   DECIMAL     (9)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ申込番号 */
     zrnseihowebsekykkigenymd                           DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ設計書有効期限年月日 */
     zrnseihowebsksjsitencd                             CHAR        (4)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ作成時支店コード */
     zrnseihowebsbuktnrkkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ死亡受取人入力区分 */
     zrnseihowebsbukttdkkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ死亡受取人続柄区分 */
     zrnseihowebsbuktknnm                               CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ死亡受取人カナ氏名 */
     zrnseihowebsbuktkjnm                               GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ死亡受取人漢字氏名 */
     zrnseihowebsbuktseiymd                             DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ死亡受取人生年月日 */
     zrnseihowebmosprtzmhyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ申込書印刷済表示 */
     zrnseihowebfstmossksymd                            DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ初回申込書作成年月日 */
     zrnseihowebhnsyukyktdkkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ編集後契約者続柄区分 */
     zrnseihowebbsyutrkno                               CHAR        (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ募集人登録番号 */
     zrnseihowebhjnkitikbn                              CHAR        (5)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ法人形態区分 */
     zrnseihowebhjnkykhyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ法人契約表示 */
     zrnseihowebtksykmcd1                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ特殊項目コード１ */
     zrnseihowebtksykmcd2                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ特殊項目コード２ */
     zrnseihowebtksykmcd3                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ特殊項目コード３ */
     zrnseihowebtksykmcd4                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ特殊項目コード４ */
     zrnseihowebtksykmcd5                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ特殊項目コード５ */
     zrnseihowebteiwkkn                                 DECIMAL     (9)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ低Ｗ期間 */
     zrnseihowebhhkntelno                               CHAR        (14)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者電話番号 */
     zrnseihowebkyktelno                                CHAR        (14)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者電話番号 */
     zrnseihowebknhjnnm                                 CHAR        (38)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂカナ法人名 */
     zrnseihowebkjhjnnm                                 GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ漢字法人名 */
     zrnseihowebkndaihyounm                             CHAR        (30)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂカナ代表者名 */
     zrnseihowebkjdaihyounm                             GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ漢字代表者名 */
     zrnseihowebdaihyouktgkkbn                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ代表者肩書区分 */
     zrnseihowebsykihrkp1                               DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ初回払込Ｐ１ */
     zrnseihowebmosp1                                   DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ申込Ｐ１ */
     zrnseihowebtkiyougyoutaikbn                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ統計用業態区分 */
     zrnseihowebpaperlessmoshyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂペーパーレス申込表示 */
     zrnseihowebdatasousinzmhyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂデータ送信済表示 */
     zrnseihowebdrtnskno                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ代理店設計書番号 */
     zrnseihowebsbnksyukbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ死亡年金種類区分 */
     zrnseihowebaatkisyaknyuucd                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＡ扱者金融機関コード */
     zrnseihowebkeihidouituhyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契被同一表示 */
     zrnseihowebsiteituukakbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ指定通貨区分 */
     zrnseihowebnykntuukakbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ入金通貨区分 */
     zrnseihowebtargettkarihyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂターゲット特約有表示 */
     zrnseihowebtargettkkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂターゲット特約区分 */
     zrnseihowebtargettkmkht                            DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂターゲット特約目標値 */
     zrnseihowebnykntuukanykngk                         DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ入金通貨入金額 */
     zrnseihowebnykntukfsthrkp                          DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ入金通貨初回払込Ｐ */
     zrnseihowebnykntuknexthrkp                         DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ入金通貨次回払込Ｐ */
     zrnseihowebsaimankihyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ才満期表示 */
     zrnseihowebrayhyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＲＡＹ表示 */
     zrnseihowebgnykntuknykngk                          DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ外貨入金通貨入金額 */
     zrnseihowebgnykntukfsthrkp                         DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ外貨入金通貨初回Ｐ */
     zrnseihowebgnykntuknxthrkp                         DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ外貨入金通貨次回Ｐ */
     zrnseihowebgaikakihonp                             DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ外貨基本Ｐ */
     zrnseihowebkaigmehrtkarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ介護前払特約有表示 */
     zrnseihowebyenhsyutkarihyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ円最低保証特約有表示 */
     zrnseihowebgaikakihons                             DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ外貨基本Ｓ */
     zrnseihowebdai1hknkkn                              DECIMAL     (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ第１保険期間 */
     zrnseihowebkyksykgycd                              CHAR        (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者職業コード */
     zrnseihowebkknmskhjnkitikbn                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契勤務先法人形態区分 */
     zrnseihowebkykottmsk                               GRAPHIC     (60)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ契約者お勤め先 */
     zrnseihowebhhknsykgycd                             CHAR        (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者職業コード */
     zrnseihowebhknmskhjnkitikbn                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被勤務先法人形態区分 */
     zrnseihowebhhknottmsk                              GRAPHIC     (60)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者お勤め先 */
     zrnseihowebhhknnensyuukbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被保険者年収区分 */
     zrnseihowebplhhknkjnm                              GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ被保険者漢字氏名 */
     zrnseihowebplkykkjnm                               GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ契約者漢字氏名 */
     zrnseihowebplhrkkeirokbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ払込経路区分 */
     zrnseihowebplsbuktnrkkbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ死亡受入力区分 */
     zrnseihowebplsbukttdkkbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ死亡受続柄区分 */
     zrnseihowebplsbuktknnm                             CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ死亡受カナ氏名 */
     zrnseihowebplsbuktkjnm                             GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ死亡受漢字氏名 */
     zrnseihowebplsbuktseiymd                           DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ死亡受生年月日 */
     zrnseihowebplhhkntelno                             CHAR        (14)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ被保険者電話番号 */
     zrnseihowebplkyktelno                              CHAR        (14)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ契約者電話番号 */
     zrnseihowebplkihontikucd                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ基本地区コード */
     zrnseihowebpltsinadrkai                            GRAPHIC     (62)                                                      NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ通信先住所下位 */
     zrnseihowebplhiikihontikucd                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ被基本地区コード */
     zrnseihowebplhhknadr                               GRAPHIC     (124)                                                     NOT NULL  ,  /* （連携用）生保ＷｅｂＰＬ被保険者住所 */
     zrnseihowebhnyppltzmhyj                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ汎用ＰＰＬ対応済表示 */
     zrnseihowebssrndhbnwr                              DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ指数連動部分配分割合 */
     zrnseihowebtrtrndhbnwr                             DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ定率積立部分配分割合 */
     zrnseihowebsueokikkn                               DECIMAL     (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ据置期間 */
     zrnseihowebmnkuktnrkkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ満期受取人入力区分 */
     zrnseihowebmnkukttdkkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ満期受取人続柄区分 */
     zrnseihowebmnkuktknnm                              CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ満期受取人カナ氏名 */
     zrnseihowebmnkuktkjnm                              GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ満期受取人漢字氏名 */
     zrnseihowebmnkuktseiymd                            DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ満期受取人生年月日 */
     zrnseihowebankenkanrino                            CHAR        (15)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ案件管理番号 */
     zrnseihowebikkatup                                 DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ一括払Ｐ */
     zrnseihowebikkatubaraikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ一括払区分 */
     zrnseihowebiktbrikaisuu                            DECIMAL     (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ一括払回数 */
     zrnseihowebzennoup                                 DECIMAL     (10)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ前納Ｐ */
     zrnseihowebgaikazennoup                            DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ外貨前納Ｐ */
     zrnseihowebzennoukkn                               DECIMAL     (2)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ前納期間 */
     zrnseihowebzennouhyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ前納表示 */
     zrnseihowebkydbosyuukjncd                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ共同募集個人コード */
     zrnseihowebkzktrkmoskbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族登録申込区分 */
     zrnseihowebkzktdkkbn1                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族続柄区分１ */
     zrnseihowebkzkknnm1                                CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族カナ氏名１ */
     zrnseihowebkzkkjnm1                                GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族漢字氏名１ */
     zrnseihowebkzkseikbn1                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族性別区分１ */
     zrnseihowebkzkseiymd1                              DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族生年月日１ */
     zrnseihowebkzkkykdoukyohyj1                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族契同居表示１ */
     zrnseihowebkzkyno1                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族郵便番号１ */
     zrnseihowebkzkadr1                                 GRAPHIC     (62)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族住所１ */
     zrnseihowebkzktelno1                               CHAR        (14)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂご家族電話番号１ */
     zrnseihowebkykdrtkkanouhyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契代理特約可能表示 */
     zrnseihowebhhkndrtkkanouhyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被代理特約可能表示 */
     zrnseihowebdrtkkbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ代理特約区分 */
     zrnseihowebkykdrnrkkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ契代理入力区分 */
     zrnseihowebhhkndrnrkkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被代理入力区分 */
     zrnseihowebhhkndrtdkkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生保Ｗｅｂ被代理続柄区分 */
     zrnseihowebhhkndrknnm                              CHAR        (18)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ被代理カナ氏名 */
     zrnseihowebhhkndrkjnm                              GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）生保Ｗｅｂ被代理漢字氏名 */
     zrnseihowebhhkndrseiymd                            DECIMAL     (8)                                                       NOT NULL     /* （連携用）生保Ｗｅｂ被代理生年月日 */
)
;

ALTER TABLE ZT_SmbcBosRn_Z ADD CONSTRAINT PK_SmbcDairitenSekMosRn PRIMARY KEY (
     zrnseihowebidkbn                                         , /* （連携用）生保ＷｅｂＩＤ区分 */
     zrnseihowebkojincd                                       , /* （連携用）生保Ｗｅｂ個人コード */
     zrnseihowebitijihozonhyouji                              , /* （連携用）生保Ｗｅｂ一時保存表示 */
     zrnseihowebsekno                                           /* （連携用）生保Ｗｅｂ設計書番号 */
) ;
