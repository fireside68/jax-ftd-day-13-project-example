import net from 'net'
import vorpal from 'vorpal'
import bcrypt from 'bcrptjs'

const testfile = vorpal()
let server
let db = {}

const register = testfile.register('register <username> <password>')
register
  .description('Registers users for server access')

const connect = testfile.connect('connect <username> <password>')
connect
  .description('Connect users, hopefully, to a server')
  .action()
