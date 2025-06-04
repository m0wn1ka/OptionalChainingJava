# Optional Chaining Java
## concepts
- java ,reflection, null pointer exception

## usage scenario
- the most common exception which would be null pointer exception which would halt the execution
- this happens when we try to access a propery on a null
- in react we have optional chaining a?.b?.c
- in java what we do is
```
if(a!=null && a.b!=nll && a.b.c!=null){
return a.b.c
}
```
- many times this is tired some and we miss it
- so using this utility function we can avoid this exception

## how to use
- we want to access a.b.c
- in build.gradle
```
  repositories {
	maven { url 'https://jitpack.io' }
	mavenCentral()
}

dependencies {
implementation 'com.github.m0wn1ka:OptionalChainingJava:v1.0.1'
}

```
- so we call Radha.getNullSafeValue(a,"b?.c)
## how it works
- it checks for a(root object) is null or the path ("b?.c")  is null
- then it splits the path using regex and get the properties that we want to access [b,c]
- then on the current object it tries to get the field (b and then c iterativly)
- sets the field as accesible (private fields)
- then accesses the property by field.get(current object)
- then again iterates
- if any time the field value is null or field does not exist it returns null to avoid exception
- so iteratively it gets a.b.c
## how is it published
- push the code
- make sure the group in build.gralde is com.github.yourUserName
- create a release tag in github
