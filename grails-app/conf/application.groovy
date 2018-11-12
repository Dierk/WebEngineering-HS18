
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'mvs.SecUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'mvs.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'mvs.SecRole'

grails.plugin.springsecurity.logout.postOnly = false // allow logout via get url /logout

final statics = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.controllerAnnotations.staticRules = statics

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


// config types are 'Annotation', 'Requestmap', or 'InterceptUrlMap'
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = statics + [
	[pattern: "/login/auth", access: ["permitAll"]],
	[pattern: "/person/**" , access: ['ROLE_ADMIN']], // cannot use constant here :-(
	[pattern: "/room/**"   , access: ['ROLE_ADMIN']],

//    [pattern: "/static/Calculator.html", access: ['ROLE_ADMIN', 'ROLE_GUEST']], // secured for testing security
//    [pattern: "/calculator/*",           access: ['ROLE_ADMIN', 'ROLE_GUEST']], // secured for testing security

//    [pattern: "/static/Calculator.html", access: ['permitAll']], // unsecured for ease of testing
//    [pattern: "/calculator/**",           access: ['permitAll']],
//
//    [pattern: "/InPlaceCalculator.html" ,       access: ['permitAll']], // unsecured for ease of testing
//    [pattern: "/inPlaceCalculator/**" ,          access: ['permitAll']],
//   	[pattern: "/multiplicationCircle.html" ,    access: ['permitAll']],
//   	[pattern: "/multiplicationCircle/**" ,       access: ['permitAll']],
//   	[pattern: "/static/Temperatures.html",      access: ['permitAll']],

//	[pattern: "/**",                            access: ['ROLE_ADMIN', 'ROLE_GUEST']], // default
	[pattern: "/**",                            access: ['permitAll']], // default
]