package com.example.gdd_ideas.database

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.gdd_ideas.database.daos.ProjDao
import com.example.gdd_ideas.database.daos.ProjDao_Impl
import com.example.gdd_ideas.database.daos.UserDao
import com.example.gdd_ideas.database.daos.UserDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class MyDataBase_Impl : MyDataBase() {
  private val _userDao: Lazy<UserDao> = lazy {
    UserDao_Impl(this)
  }

  private val _projDao: Lazy<ProjDao> = lazy {
    ProjDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1,
        "cf4632c6f2d24c5d7b2a9c357b68083b", "6949c8af4ef6c66bb0596e0a74b94a1d") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `tb_user` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `tb_proj` (`idProj` TEXT NOT NULL, `projName` TEXT NOT NULL, `projDesc` TEXT NOT NULL, `fkUser` TEXT NOT NULL, PRIMARY KEY(`idProj`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf4632c6f2d24c5d7b2a9c357b68083b')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `tb_user`")
        connection.execSQL("DROP TABLE IF EXISTS `tb_proj`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsTbUser: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsTbUser.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTbUser.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTbUser.put("email", TableInfo.Column("email", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTbUser.put("password", TableInfo.Column("password", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysTbUser: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesTbUser: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoTbUser: TableInfo = TableInfo("tb_user", _columnsTbUser, _foreignKeysTbUser,
            _indicesTbUser)
        val _existingTbUser: TableInfo = read(connection, "tb_user")
        if (!_infoTbUser.equals(_existingTbUser)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |tb_user(com.example.gdd_ideas.database.entities.User).
              | Expected:
              |""".trimMargin() + _infoTbUser + """
              |
              | Found:
              |""".trimMargin() + _existingTbUser)
        }
        val _columnsTbProj: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsTbProj.put("idProj", TableInfo.Column("idProj", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTbProj.put("projName", TableInfo.Column("projName", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTbProj.put("projDesc", TableInfo.Column("projDesc", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTbProj.put("fkUser", TableInfo.Column("fkUser", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysTbProj: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesTbProj: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoTbProj: TableInfo = TableInfo("tb_proj", _columnsTbProj, _foreignKeysTbProj,
            _indicesTbProj)
        val _existingTbProj: TableInfo = read(connection, "tb_proj")
        if (!_infoTbProj.equals(_existingTbProj)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |tb_proj(com.example.gdd_ideas.database.entities.Proj).
              | Expected:
              |""".trimMargin() + _infoTbProj + """
              |
              | Found:
              |""".trimMargin() + _existingTbProj)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "tb_user", "tb_proj")
  }

  public override fun clearAllTables() {
    super.performClear(false, "tb_user", "tb_proj")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(UserDao::class, UserDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(ProjDao::class, ProjDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun getUserDao(): UserDao = _userDao.value

  public override fun getProjDao(): ProjDao = _projDao.value
}
